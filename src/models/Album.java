package models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;


public class Album implements IAlbum {
    Photo[] photos;
    int size;

    public Album(int capacity) {
        this.photos = new Photo[capacity];
    }

//    @Override
//    public boolean addPhoto(Photo photo) {
//        try {
//            if (getPhotoFromAlbum(photo.getAlbumId(), photo.getPhotoId()) == null) {
////            Photo[] start = Arrays.copyOfRange(photos, 0, Math.abs(index + 1)+1);
//                photos[size] = photo;
//                size++;
//                return true;
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Sorry, memory is full");
//            return false;
//        }
//        return false;
//    }

    @Override
    public boolean addPhoto(Photo photo) {
//        try {
        if (size == photos.length || getPhotoFromAlbum(photo.getAlbumId(), photo.getPhotoId()) != null) {
            return false;
        }

        int index = searchBinary(photo);
        index = index >= 0 ? index : -index - 1;

        Photo[] res = new Photo[photos.length + 1];
        System.arraycopy(photos, 0, res, 0, index);
        System.arraycopy(photos, index, res, index + 1, size - index);
        res[index] = photo;

        photos = res;
        size++;
        return true;


//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Sorry, memory is full");
//            return false;
//        }
    }


    public int searchBinary(Photo photo) {
        int left = 0;
        int right = this.size;
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
        Photo p = getPhotoFromAlbum(albumId, photoId);
        if (p != null) {
            p.setUrl(url);
            return true;
        }
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int albumId, int photoId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].photoId == photoId && photos[i].albumId == albumId) {
                Photo photo = photos[i];
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
