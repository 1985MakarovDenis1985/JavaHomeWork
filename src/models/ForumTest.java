package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ForumTest extends Forum {
    IForum forum;
    Post[] posts;

    @BeforeEach
    void setUp() {
        forum = new Forum();
        Post p = new Post("Jms", 1, "smt", "Hello");
        p.setDate(LocalDateTime.of(2025, 3, 21, 19, 47, 45));
        forum.addPost(p);
        p = new Post("MJs", 2, "smt", "Hello");
        p.setDate(LocalDateTime.of(2019, 1, 11, 6, 17, 35));
        forum.addPost(p);
        p = new Post("SmJ", 3, "smt", "Hello");
        p.setDate(LocalDateTime.of(2021, 6, 17, 12, 15, 17));
        forum.addPost(p);
        p = new Post("Jsm", 4, "smt", "Hello");
        p.setDate(LocalDateTime.of(2023, 1, 27, 21, 36, 57));
        forum.addPost(p);
    }

    @Test
    void testAddPost() {
        forum.addPost(new Post("MJs", 7, "smt", "Hey"));
        assertEquals(5, forum.size());
        forum.addPost(new Post("MJs", 3, "smt", "Hey"));
        assertEquals(5, forum.size());
    }

    @Test
    void testRemovePost() {
        forum.removePost(2);
        assertEquals(3, forum.size());
        assertNull(forum.getPostById(2));
        forum.removePost(2);
        assertFalse(forum.removePost(2));
    }

    @Test
    void testUpdatePost() {
        assertTrue(forum.updatePost(4, "Updated"));
        assertFalse(forum.updatePost(7, "Updated"));
    }

    @Test
    void testGetPostById() {
        Post p = new Post("MJs", 2, "smt", "Hello");
        assertEquals(p, forum.getPostById(2));
        assertNull(forum.getPostById(7));
    }
//
//    @Test
//    void testGetByAuthor() {
//    }
//
//    @Test
//    void testGetByAuthor1() {
//    }

    @Test
    void testSize() {
        IForum forum = new Forum();
        assertEquals(0, forum.size());
        forum.addPost(new Post("Jms", 1, "smt", "Hello"));
        forum.addPost(new Post("MJs", 3, "smt", "Hey"));
        assertEquals(2, forum.size());
    }
}