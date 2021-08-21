package tests;

import models.Forum;
import models.IForum;
import models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ForumTest extends Forum {
    IForum forum;
    Post[] posts;

    @BeforeEach
    void setUp() {
        forum = new Forum();
        Post p = new Post("Jimmy", 1, "smt", "Hello");
        p.setDate(LocalDateTime.of(2025, 3, 21, 19, 47, 45));
        forum.addPost(p);
        p = new Post("Nelson", 2, "smt", "Hello");
        p.setDate(LocalDateTime.of(2019, 2, 11, 6, 17, 35));
        forum.addPost(p);
        p = new Post("Jimmy", 3, "smt", "Hello");
        p.setDate(LocalDateTime.of(2021, 6, 17, 12, 15, 17));
        forum.addPost(p);
        p = new Post("Nelson", 4, "smt", "Hello");
        p.setDate(LocalDateTime.of(2023, 1, 27, 21, 36, 57));
        forum.addPost(p);
    }

    @Test
    void testAddPost() {
        forum.addPost(new Post("Nelson", 7, "smt", "Hey"));
        assertEquals(5, forum.size());
        forum.addPost(new Post("Jimmy", 3, "smt", "Hey"));
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
        Post p = new Post("Jimmy", 2, "smt", "Hello");
        assertEquals(p, forum.getPostById(2));
        assertNull(forum.getPostById(7));
    }

    @Test
    void testGetByAuthor() {
        Post[] arr = forum.getByAuthor("Jimmy");
        assertEquals(2, arr.length);
        Post p = new Post("Jimmy", 7, "smt", "Hello");
        p.setDate(LocalDateTime.of(2022, 3, 27, 21, 43, 11));
        forum.addPost(p);
        arr = forum.getByAuthor("Jimmy");
        assertEquals(3, arr.length);
        arr = forum.getByAuthor("Simon");
        assertEquals(0, arr.length);
    }

    @Test
    void testGetByAuthorAndDate() {
        Post p1 = new Post("Jimmy", 7, "smt", "Hello");
        p1.setDate(LocalDateTime.of(2021, 3, 21, 19, 47, 45));
        forum.addPost(p1);
        Post p2 = new Post("Jimmy", 8, "smt", "Hello");
        p2.setDate(LocalDateTime.of(2021, 7, 11, 6, 17, 35));
        forum.addPost(p2);
        Post[] arr = forum.getByAuthor("Jimmy", LocalDate.of(2019, 1, 8), LocalDate.of(2022, 12, 8));
        assertEquals(3, arr.length);
        assertEquals(p1, forum.getPostById(7));
        assertEquals(p2, forum.getPostById(8));
        assertEquals(new Post("Jimmy", 3, "smt", "Hello"), forum.getPostById(3));
    }

    @Test
    void testSize() {
        IForum forum = new Forum();
        assertEquals(0, forum.size());
        forum.addPost(new Post("Jimmy", 1, "smt", "Hello"));
        forum.addPost(new Post("Nelson", 3, "smt", "Hey"));
        assertEquals(2, forum.size());
    }
}