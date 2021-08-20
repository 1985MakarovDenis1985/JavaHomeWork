package controller;

import models.Forum;
import models.Post;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Controller {

    public static void main(String[] args) {
//        Post[] posts = {
//                new Post("Jms",1, "smt", "Hello"),
//                new Post("MJs",2, "smt", "Hey"),
//                new Post("SmJ",3, "smt", "By"),
//        };
//        posts[0].setDate(LocalDateTime.of(2018, 8, 11, 13, 3, 15));
//        posts[1].setDate(LocalDateTime.of(2021, 8, 11, 13, 3, 15));
//        posts[2].setDate(LocalDateTime.of(2017, 8, 11, 13, 3, 15));
        Forum forum = new Forum();
        forum.addPost(new Post("Jms",1, "smt", "Hello"));
        forum.addPost(new Post("MJs",3, "smt", "Hey"));
        forum.addPost(new Post("SmJ",7, "smt", "By"));
        forum.addPost(new Post("Jms",2, "smt", "Hello"));
//        forum.addPost(new Post("MJs",6, "smt", "Hey"));
//        forum.addPost(new Post("SMJ",4, "smt", "Good"));
//        forum.addPost(new Post("SmJ",5, "smt", "By"));
//        forum.addPost(new Post("SmJ",8, "smt", "By"));


        forum.printForum();
        System.out.println(forum.size());

    }

}
