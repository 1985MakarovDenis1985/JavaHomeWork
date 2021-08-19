package controller;

import models.Album;
import models.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class AlbumsController {
    public static void main(String[] args) {
        Album album = new Album(7);
        album.addPhoto(new Photo(1, 1000, "Jasmin", "songs", LocalDateTime.of(2018, 8, 11, 13, 3, 15)));
//        album.addPhoto(new Photo(2, 2000, "Jasmin", "songs", LocalDateTime.of(2019, 7, 7, 21, 11, 30)));
        album.addPhoto(new Photo(3, 3000, "Jasmin", "songs", LocalDateTime.of(2021, 3, 21, 19, 47, 45)));
//        album.addPhoto(new Photo(4, 4000, "Jasmin", "songs", LocalDateTime.of(2023, 1, 17, 11, 8, 15)));
//        album.addPhoto(new Photo(2, 2000, "Jasmin", "songs", LocalDateTime.of(2019, 7, 7, 21, 11, 30)));
        album.addPhoto(new Photo(6, 6000, "Jasmin", "songs", LocalDateTime.of(2019, 8, 7, 21, 11, 30)));
        album.addPhoto(new Photo(9, 9000, "Jasmin", "songs", LocalDateTime.of(2021, 2, 11, 3, 21, 17)));
        album.addPhoto(new Photo(5, 5000, "Jasmin", "songs", LocalDateTime.of(2019, 1, 7, 21, 5, 30)));
        album.addPhoto(new Photo(4, 4000, "Jasmin", "songs", LocalDateTime.of(2023, 1, 17, 11, 8, 15)));
        album.addPhoto(new Photo(2, 2000, "Jasmin", "songs", LocalDateTime.of(2019, 7, 7, 21, 11, 30)));

        // уже такой есть
//        album.addPhoto(new Photo(100, 3000, "Jasmin", "songs", LocalDateTime.of(2021, 3, 21, 19, 47, 45)));
        album.addPhoto(new Photo(5, 5000, "Jasmin", "songs", LocalDateTime.of(2025, 11, 19, 22, 7, 35)));
//        album.addPhoto(new Photo(4, 4000, "Jasmin", "songs", LocalDateTime.of(2023, 1, 17, 11, 8, 15)));



//        album.removePhoto(3,3000);
//        album.removePhoto(2,2000);
//        album.removePhoto(2,2000);
//        album.removePhoto(6,6000);


//        album.updatePhoto(2,2000, "movie");
//        album.printArr();
//        Photo photo = album.getPhotoFromAlbum(3, 3000);
//        System.out.println("get photo => " + photo);
//        Photo[] sa = album.getAllPhotosFromAlbum(100);
//        printArr(sa);

        Photo[] p = album.getPhotoBetweenDate(LocalDate.of(2020, 1, 17), LocalDate.of(2023, 8, 17));

        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);

        }



        System.out.println("==== all =====");

//        album.printArr();


//        System.out.println("--------");
//        Photo a = new Photo(5, 5000, "Jasmin", "songs", LocalDateTime.of(2025, 11, 19, 22, 7, 35));
//        Photo a = new Photo(9, 9000, "Jasmin", "songs", LocalDateTime.of(2021, 3, 21, 19, 47, 45));
    }
//
//    public static void printArr(Photo[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }

}
