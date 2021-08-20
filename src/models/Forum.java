package models;

import java.time.LocalDate;
import java.util.Arrays;

public class Forum implements IForum {
    Post[] posts = new Post[3];
    int size;
    private Post[] newPostsArr;


    @Override
    public boolean addPost(Post post) {
        try {
            if (getPostById(post.postId) != null){
                return false;
            }
            int index = Arrays.binarySearch(posts,0, size, post);
            index = index > 0 ? index : -index-1;
            System.arraycopy(posts, index, posts, index + 1, size - index);
            posts[index] = post;
            size++;
            return true;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            Post[] newPosts = new Post[size + 3];
            for (int i = 0; i < posts.length; i++) {
                newPosts[i] = posts[i];
            }
            int index = Arrays.binarySearch(newPosts,0, size, post);
            index = index > 0 ? index : -index-1;
            System.arraycopy(newPosts, index, newPosts, index + 1, size - index);


            posts = newPosts;
            posts[index] = post;
            size++;
            return true;
        }
    }



    @Override
    public boolean removePost(int postId) {
        return false;
    }

    @Override
    public boolean updatePost(int postId, String content) {
        return false;
    }

    @Override
    public Post getPostById(int postId) {
        return null;
    }

    @Override
    public Post[] getByAuthor(String author) {
        return new Post[0];
    }

    @Override
    public Post[] getByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        return new Post[0];
    }

    @Override
    public int size() {
        return this.size;
    }

    public void printForum(){
        for (int i = 0; i < size; i++) {
            System.out.println(posts[i]);
        }
    }
}
