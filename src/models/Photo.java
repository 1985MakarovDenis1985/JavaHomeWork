package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.zip.ZipEntry;

public class Photo implements Comparable<Photo>{
    int albumId;
    int photoId;
    String title;
    String url;
    LocalDateTime date;

    public Photo(int albumId, int photoId, String title, String url, LocalDateTime date) {
        this.albumId = albumId;
        this.photoId = photoId;
        this.title = title;
        this.url = url;
        this.date = date;
    }

    public int getAlbumId() {
        return albumId;
    }
    public int getPhotoId() {
        return photoId;
    }
    public String getTitle() {
        return title;
    }
    public String getUrl() {
        return url;
    }
    public LocalDateTime getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Photo : " +
                "albumId=" + albumId +
                ", photoId=" + photoId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return albumId == photo.albumId && photoId == photo.photoId && Objects.equals(title, photo.title) && Objects.equals(url, photo.url) && Objects.equals(date, photo.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumId, photoId, title, url, date);
    }

    @Override
    public int compareTo(Photo o) {
        return this.date.compareTo(o.date);
//        return LocalDate.from(this.getDate()).compareTo(LocalDate.from(o.getDate()));
    }
}
