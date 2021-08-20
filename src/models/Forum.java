package models;

import java.time.LocalDate;
import java.util.Arrays;

public class Forum implements IForum {
    Post[] posts = new Post[3];
    int size;

    @Override
    public boolean addPost(Post post) {
        try {
            if (getPostById(post.postId) != null) {
                return false;
            }
            addNewPostWithSort(posts, post);
//            int index = Arrays.binarySearch(posts, 0, size, post);
//            index = index > 0 ? index : -index - 1;
//            System.arraycopy(posts, index, posts, index + 1, size - index);
//            posts[index] = post;
            size++;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            Post[] newPosts = new Post[posts.length + 3];
//            for (int i = 0; i < size; i++) {
//                newPosts[i] = posts[i];
//            }
            System.arraycopy(posts, 0, newPosts, 0, size);
            addNewPostWithSort(newPosts, post);
//            int index = Arrays.binarySearch(newPosts, 0, size, post);
//            index = index > 0 ? index : -index - 1;
//            System.arraycopy(newPosts, index, newPosts, index + 1, size - index);
//            newPosts[index] = post;
            posts = newPosts;
            size++;
            return true;
        }
    }

    private void addNewPostWithSort(Post[] arr, Post post) {
        int index = Arrays.binarySearch(posts, 0, size, post);
        index = index > 0 ? index : -index - 1;
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = post;
    }

    @Override
    public boolean removePost(int postId) {
        if (getPostById(postId) == null) {
            return false;
        }
        int index = searchIndex(postId);
        System.arraycopy(posts, index + 1, posts, index, size - index - 1);
        size--;

        if (size%3 == 0){
            Post[] newPosts = new Post[size];
            System.arraycopy(posts, 0, newPosts, 0, size);
            posts = newPosts;
        }
        return true;
    }

    @Override
    public boolean updatePost(int postId, String content) {
        return false;
    }

    private int searchIndex(int postId) {
        for (int i = 0; i < size; i++) {
            if (posts[i].postId == postId) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Post getPostById(int postId) {
        int index = searchIndex(postId);
        if (index != -1) {
            return posts[index];
        }
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

    public void printForum() {
        for (int i = 0; i < size; i++) {
            System.out.println(posts[i]);
        }
    }
}
