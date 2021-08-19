package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        try {
            if (size == photos.length || getPhotoFromAlbum(photo.getAlbumId(), photo.getPhotoId()) != null) {
                return false;
            }
            int index = Arrays.binarySearch(photos, 0, size, photo);
            index = index >= 0 ? index : -index - 1;
            System.arraycopy(photos, index, photos, index + 1, size - index);
            photos[index] = photo;
            size++;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Sorry, memory is full");
            return false;
        }
    }


//    public int searchBinary(Photo photo) {
//        int left = 0;
//        int right = this.size;
//        int middle = 0;
//        while (left < right) {
//            middle = (left + right) / 2;
//            if (LocalDate.from(photos[middle].getDate()).isAfter(LocalDate.from(photo.getDate()))) {
//                right = middle;
//            } else if (LocalDate.from(photos[middle].getDate()).isBefore(LocalDate.from(photo.getDate()))) {
//                left = middle + 1;
//            } else {
//                return middle;
//            }
//        }
//        return -(left + 1);
//    }

    private int searchIndex(int albumId, int photoId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].photoId == photoId && photos[i].albumId == albumId) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean removePhoto(int albumId, int photoId) {

// ----------- new solution with separated function------------ //
        int index = searchIndex(albumId, photoId);
        if (index != -1) {
            System.arraycopy(photos, index + 1, photos, index, size - index - 1);
            size--;
            return true;
        }

// ----------- solution before ------------ //
//        for (int index = 0; index < size; index++) {
//            if (photos[index].photoId == photoId && photos[index].albumId == albumId) {
//                System.out.println(index);
//                System.arraycopy(photos, index+1, photos, index, size - index-1);
//                size--;
//                return true;
//            }
//        }
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
        int index = searchIndex(albumId, photoId);
        if (index != -1) {
            Photo photo = photos[index];
            return photo;
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

//    private int startIndex(LocalDate dateFrom){
//        int index = Arrays.binarySearch(photos, 0, size, );
//        return index;
//    }

    @Override
    public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        Photo[] photosFromAlbum;
//        int l = 0;
//        int r = 0;
        Photo startIndex = new Photo(0, 0, " ", " ", dateFrom.atStartOfDay());
        Photo endIndex = new Photo(0, 0, " ", " ", dateTo.atStartOfDay());

        int l = Arrays.binarySearch(photos, 0, size, startIndex);
        int r = Arrays.binarySearch(photos, 0, size, endIndex);

//        System.out.println(a);

//        //// find start index
//        for (int i = 0; i < size; i++) {
//            if (LocalDate.from(photos[i].getDate()).isAfter(dateFrom)) {
//                l = i;
//                break;
//            }
//        }
//         //// find end index
//        for (int i = size - 1; i > 0; i--) {
//            if (LocalDate.from(photos[i].getDate()).isBefore(dateTo)) {
//                r = i;
//                break;
//            }
//        }
        // create new arr -> then add part of photos inside new arr
        photosFromAlbum = new Photo[r - l + 1];

        // ----- solution by for ------ //
        int count = 0;
        for (int i = l; i < r+1; i++) {
            photosFromAlbum[count] = photos[i];
            count++;
        }

        // ----- solution with System.arraycopy ------ //
//        System.arraycopy(photos, l, photosFromAlbum, 0, size - l-1);


// -------------------------- sol 3 ------------------------ //

//        int count = 0;
//        Photo[] photosFromAlbum;
//
//        for (int i = 0; i < size; i++) {
//            if (LocalDate.from(photos[i].getDate()).isAfter(dateFrom) && LocalDate.from(photos[i].getDate()).isBefore(dateTo)) {
//                count++;
//            }
//        }
//        photosFromAlbum = new Photo[count];
//        count = 0;
//        for (int i = 0; i < size; i++) {
//            if (LocalDate.from(photos[i].getDate()).isAfter(dateFrom) && LocalDate.from(photos[i].getDate()).isBefore(dateTo)) {
//                photosFromAlbum[count] = photos[i];
//                count++;
//            }
//        }
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
