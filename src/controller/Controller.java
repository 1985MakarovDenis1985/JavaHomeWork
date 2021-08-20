package controller;

import models.Forum;
import models.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Controller {

    public static void main(String[] args) {
//        Post[] posts = {
//                new Post("Jms", 1, "smt", "Hello"),
//                new Post("MJs", 2, "smt", "Hey"),
//                new Post("SmJ", 3, "smt", "By"),
//        };
//        posts[0].setDate(LocalDateTime.of(2018, 8, 11, 13, 3, 15));
//        posts[1].setDate(LocalDateTime.of(2021, 8, 11, 13, 3, 15));
//        posts[2].setDate(LocalDateTime.of(2017, 8, 11, 13, 3, 15));
        Forum forum = new Forum();
        Post p = new Post("Jimmy", 1, "smt", "Hello");
        p.setDate(LocalDateTime.of(2025, 3, 21, 19, 47, 45));
        forum.addPost(p);

        p = new Post("Nelson", 2, "smt", "Hello");
        p.setDate(LocalDateTime.of(2019, 1, 11, 6, 17, 35));
        forum.addPost(p);

        p = new Post("Jimmy", 3, "smt", "Hello");
        p.setDate(LocalDateTime.of(2021, 6, 17, 12, 15, 17));
        forum.addPost(p);

        p = new Post("Nelson", 4, "smt", "Hello");
        p.setDate(LocalDateTime.of(2023, 1, 27, 21, 36, 57));
        forum.addPost(p);

        p = new Post("Jimmy", 5, "smt", "Hello");
        p.setDate(LocalDateTime.of(2022, 11, 15, 4, 15, 23));
        forum.addPost(p);

        p = new Post("Jimmy", 6, "smt", "Hello");
        p.setDate(LocalDateTime.of(2022, 5, 8, 13, 40, 57));
        forum.addPost(p);

//        forum.removePost(5);
//        forum.removePost(3);
        forum.updatePost(4, "Updated");

//        forum.printForum();
//        System.out.println(forum.size());
        System.out.println("====== all ======");

        Post[] arr = forum.getByAuthor("Jimmy", LocalDate.of(2019, 1, 8), LocalDate.of(2024, 12, 8));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
