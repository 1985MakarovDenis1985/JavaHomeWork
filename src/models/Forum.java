package models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.Predicate;

public class Forum implements IForum {
    /* chunks of size 3i*/
    private final int CHUNKS_OF_SIZE = 3;
    Post[] posts = new Post[CHUNKS_OF_SIZE];
    int size;


    @Override
    public boolean addPost(Post post) {
        try {
            if (getPostById(post.postId) != null) return false;
            addNewPostWithSort(posts, post);
            size++;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            /* increase size of arr while length is end by chunks*/
            Post[] newPosts = new Post[posts.length + CHUNKS_OF_SIZE];
            System.arraycopy(posts, 0, newPosts, 0, size);
            addNewPostWithSort(newPosts, post);
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

        /* decrease size of arr while length decreased by chunks*/
        if (size% CHUNKS_OF_SIZE == 0){
            Post[] newPosts = new Post[size];
            System.arraycopy(posts, 0, newPosts, 0, size);
            posts = newPosts;
        }
        return true;
    }

    @Override
    public boolean updatePost(int postId, String content) {
        Post p = getPostById(postId);
        if (p != null) {
            p.setContent(content);
            return true;
        }
        return false;
    }

    @Override
    public Post getPostById(int postId) {
        int index = searchIndex(postId);
        if (index != -1) {
            return posts[index];
        }
        return null;
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
    public Post[] getByAuthor(String author) {
        Post[] arrOfAuthor;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (posts[i].author.equals(author)) count++;
        }
        arrOfAuthor = new Post[count];
        count = 0;
        for (int i = 0; i < size; i++ ) {
            if (posts[i].author.equals(author)){
                arrOfAuthor[count] = posts[i];
                count++;
            }
        }
        return arrOfAuthor;
    }

    @Override
    public Post[] getByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        Post[] arrOfAuthor;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (posts[i].author.equals(author) && posts[i].date.isAfter(dateFrom.atStartOfDay()) && posts[i].date.isBefore(dateTo.atStartOfDay()))
                count++;
        }

        arrOfAuthor = new Post[count];
        count = 0;
        for (int i = 0; i < size; i++ ) {
            if (posts[i].author.equals(author) && posts[i].date.isAfter(dateFrom.atStartOfDay()) && posts[i].date.isBefore(dateTo.atStartOfDay())){
                arrOfAuthor[count] = posts[i];
                count++;
            }
        }
        return arrOfAuthor;

//---- solution with binary search ---- //
//        Post[] arrOfAuthor = getByAuthor(author);
//        Post startIndex = new Post(" ", 0, "", "");
//        startIndex.setDate(dateFrom.atStartOfDay());
//        Post endIndex = new Post(" ", 0, "", "");
//        endIndex.setDate(dateTo.atStartOfDay());
//
//        int start = -Arrays.binarySearch(arrOfAuthor, 0, arrOfAuthor.length, startIndex) -1 ;
//        int end = -Arrays.binarySearch(arrOfAuthor, 0, arrOfAuthor.length, endIndex) - 1;
//
//        Post[] arrOfDate = new Post[end - start];
//        System.arraycopy(arrOfAuthor, start, arrOfDate, 0, end-start);
//        return arrOfDate;
    }

    @Override
    public int size() {return this.size;}
}
