package models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IForum {
    boolean addPost(Post post);
    boolean removePost(int postId);
    boolean updatePost(int postId, String content);
    Post getPostById(int postId);
    Post[] getByAuthor(String author);
    Post[] getByAuthor(String author, LocalDate dateFrom,  LocalDate dateTo);
    int size();
}
