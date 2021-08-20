package models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post implements Comparable<Post>{
    String author;
    int postId;
    String title;
    String content;
    LocalDateTime date = LocalDateTime.now();
    int likes;

    public Post(String author, int postId, String title, String content) {
        this.author = author;
        this.postId = postId;
        this.title = title;
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post : " +
                "author='" + author + '\'' +
                ", postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", likes=" + likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return postId == post.postId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId);
    }

    public int addLike(){
        return this.likes+=1;
    }

    @Override
    public int compareTo(Post otherPost) {
//        return this.postId - otherPost.postId;
        return this.date.compareTo(otherPost.date);
    }
}
