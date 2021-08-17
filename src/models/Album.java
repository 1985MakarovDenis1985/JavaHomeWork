package models;

import interfaces.IAlbums;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class Album implements IAlbums {
    Photo[] photos;
    int size;

    public Album(int capacity) {
        this.photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        if (size < photos.length && getPhotoFromAlbum(photo.getAlbumId(), photo.getPhotoId()) == null) {
            photos[size] = photo;
            size++;
            return true;
        }
        return false;
    }


    public int searchBinary(Photo photo) {
        int left = 0;
        int right = size - 1;
        int middle = 0;
        while (left < right) {
            middle = (left + right) / 2;
            if (LocalDate.from(photos[middle].getDate()).isAfter(LocalDate.from(photo.getDate()))) {
                right = middle;
            } else if (LocalDate.from(photos[middle].getDate()).isBefore(LocalDate.from(photo.getDate()))) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -(left + 1);
    }


    @Override
    public boolean removePhoto(int albumId, int photoId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].photoId == photoId && photos[i].albumId == albumId) {
                photos[i] = photos[--size];
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int albumId, int photoId, String url) {
        for (int i = 0; i < size; i++) {
            if (photos[i].photoId == photoId && photos[i].albumId == albumId) {
                photos[i].setUrl(url);
                return true;
            }
        }
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int albumId, int photoId) {
        Photo photo;
        for (int i = 0; i < size; i++) {
            if (photos[i].photoId == photoId && photos[i].albumId == albumId) {
                photo = photos[i];
                return photo;
            }
        }
        return null;
    }

    @Override
    public Photo[] getAllPhotosFromAlbum(int albumId) {
        int count = 0;
        Photo[] photosFromAlbum;

        for (int i = 0; i < size; i++) {
            if (photos[i].albumId == albumId) {
                count++;
            }
        }
        photosFromAlbum = new Photo[count];
        count = 0;
        for (int i = 0; i < size; i++) {
            if (photos[i].albumId == albumId) {
                photosFromAlbum[count] = photos[i];
                count++;
            }
        }
        return photosFromAlbum;
    }


    @Override
    public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        int count = 0;
        Photo[] photosFromAlbum;

        for (int i = 0; i < size; i++) {
            if (LocalDate.from(photos[i].getDate()).isAfter(dateFrom) && LocalDate.from(photos[i].getDate()).isBefore(dateTo)) {
                count++;
            }
        }
        photosFromAlbum = new Photo[count];
        count = 0;
        for (int i = 0; i < size; i++) {
            if (LocalDate.from(photos[i].getDate()).isAfter(dateFrom) && LocalDate.from(photos[i].getDate()).isBefore(dateTo)) {
                photosFromAlbum[count] = photos[i];
                count++;
            }
        }
        return photosFromAlbum;
    }

    @Override
    public int size() {
        return size;
    }

    public void printArr() {
        for (int i = 0; i < size; i++) {
            System.out.println(photos[i]);
        }
    }
}
