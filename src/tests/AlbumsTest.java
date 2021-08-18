package tests;

import models.IAlbum;
import models.Album;
import models.Photo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AlbumsTest {

    IAlbum albums;
    Photo[] photos;

    @BeforeEach
    void setUp() {
        albums = new Album(5);
        photos = new Photo[4];
        photos[0] = new Photo(1, 1000, "birthday", "photo/Asia", LocalDateTime.of(2018, 8, 11, 13, 3, 15));
        photos[1] = new Photo(2, 2000, "wedding", "photo/Europe", LocalDateTime.of(2019, 7, 7, 21, 11, 30));
        photos[2] = new Photo(3, 3000, "walking", "photo/Asia", LocalDateTime.of(2021, 3, 21, 19, 47, 45));
        photos[3] = new Photo(2, 2200, "walking", "photo/Europe", LocalDateTime.of(2022, 3, 21, 19, 47, 45));

        for (int i = 0; i < photos.length; i++) {
            albums.addPhoto(photos[i]);
        }
    }

    @Test
    void testAddPhoto() {
        assertFalse(albums.addPhoto(photos[1]));
        Photo p1 = new Photo(5, 5000, "Jasmin", "photo/USA", LocalDateTime.of(2025, 3, 21, 19, 47, 45));
        assertTrue(albums.addPhoto(p1));
        Assertions.assertEquals(p1, albums.getPhotoFromAlbum(5, 5000));
        Photo p2 = new Photo(6, 6000, "Jasmin", "photo/USA", LocalDateTime.of(2025, 3, 21, 19, 47, 45));
        assertFalse(albums.addPhoto(p2));
    }


    @Test
    void testRemovePhoto() {
        albums.removePhoto(2, 2000);
        assertNull(albums.getPhotoFromAlbum(2, 2000));
        assertEquals(3, albums.size());
        assertFalse(albums.removePhoto(2, 2000));
        assertEquals(3, albums.size());
        assertFalse(albums.removePhoto(2, 2000));
    }

    @Test
    void testUpdatePhoto() {
        Photo p = new Photo(2, 2000, "wedding", "photo/Ukraine", LocalDateTime.of(2019, 7, 7, 21, 11, 30));
        albums.updatePhoto(2, 2000, "photo/Ukraine");
        assertEquals(p, albums.getPhotoFromAlbum(2, 2000));
        assertFalse(albums.updatePhoto(6, 6000, "photo/USA"));
    }

    @Test
    void testGetPhotoFromAlbum() {
        assertNull(albums.getPhotoFromAlbum(7, 7000));
        Photo p = new Photo(7, 7000, "wedding", "Ukraine", LocalDateTime.of(2019, 7, 7, 21, 11, 30));
        albums.addPhoto(p);
        assertEquals(p, albums.getPhotoFromAlbum(7, 7000));
    }

    @Test
    void testGetAllPhotosFromAlbum() {
        Photo[] p = albums.getAllPhotosFromAlbum(2);
        assertEquals(2, p.length);
        p = albums.getAllPhotosFromAlbum(1);
        assertEquals(1, p.length);
    }

    @Test
    void testGetPhotoBetweenDate() {
        Photo[] pArr = albums.getPhotoBetweenDate(LocalDate.of(2019, 5, 17), LocalDate.of(2022, 1, 17));
        assertEquals(2, pArr.length);
        Photo p = albums.getPhotoFromAlbum(2,2000);
        assertEquals(p, photos[1]);
        p = albums.getPhotoFromAlbum(3,3000);
        assertEquals(p, photos[2]);
        pArr = albums.getPhotoBetweenDate(LocalDate.of(2018, 1, 17), LocalDate.of(2022, 2, 17));
        assertEquals(3, pArr.length);
    }

    @Test
    void testSize() {
        assertEquals(4, albums.size());
        albums.addPhoto(new Photo(7, 7000, "wedding", "Ukraine", LocalDateTime.of(2019, 7, 7, 21, 11, 30)));
        assertEquals(5, albums.size());
        albums.removePhoto(2,2000);
        assertEquals(4, albums.size());
        albums.removePhoto(2,2000);
        assertEquals(4, albums.size());
        albums.addPhoto(new Photo(7, 7000, "wedding", "Ukraine", LocalDateTime.of(2019, 7, 7, 21, 11, 30)));
        assertEquals(4, albums.size());
    }
}