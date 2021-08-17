package controller;

import models.Album;
import models.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class AlbumsController {
    public static void main(String[] args) {
        Album album = new Album(5);
        album.addPhoto(new Photo(1, 1000, "Jasmin", "songs", LocalDateTime.of(2018, 8, 11, 13, 3, 15)));
        album.addPhoto(new Photo(2, 2000, "Jasmin", "songs", LocalDateTime.of(2019, 7, 7, 21, 11, 30)));
//        album.addPhoto(new Photo(3, 3000, "Jasmin", "songs", LocalDateTime.of(2021, 3, 21, 19, 47, 45)));
        album.addPhoto(new Photo(4, 4000, "Jasmin", "songs", LocalDateTime.of(2023, 1, 17, 11, 8, 15)));
        // уже такой есть
//        album.addPhoto(new Photo(100, 3000, "Jasmin", "songs", LocalDateTime.of(2021, 3, 21, 19, 47, 45)));
//        album.addPhoto(new Photo(5, 5000, "Jasmin", "songs", LocalDateTime.of(2025, 11, 19, 22, 7, 35)));



//        album.removePhoto(2,2000);
//        album.updatePhoto(2,2000, "movie");
//        album.printArr();
//        Photo photo = album.getPhotoFromAlbum(3, 3000);
//        System.out.println("get photo => " + photo);
//        Photo[] sa = album.getAllPhotosFromAlbum(100);
//        printArr(sa);
//        Photo[] p = album.getPhotoBetweenDate(LocalDate.of(2019, 5, 17), LocalDate.of(2023, 8, 17));
//        printArr(p);
        album.printArr();
        System.out.println("--------");
//        Photo a = new Photo(5, 5000, "Jasmin", "songs", LocalDateTime.of(2025, 11, 19, 22, 7, 35));
        Photo a = new Photo(3, 3000, "Jasmin", "songs", LocalDateTime.of(2021, 3, 21, 19, 47, 45));
        int n = album.searchBinary(a);
        System.out.println(n);



    }

    public static void printArr(Photo[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
