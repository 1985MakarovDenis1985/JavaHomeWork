package tests;
import model.Anagram;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnagramTest extends Anagram {
    String word = "electricity";

    @Test
    void testIsAnagram() {
        assertTrue(isAnagram(word, "city"));
        assertTrue(isAnagram(word, "tic"));
        assertTrue(isAnagram(word, "City"));
        assertTrue(isAnagram(word, "rele"));
        assertTrue(isAnagram(word, "tele"));
    }

    @Test
    void testIsNotAnagram() {
        assertFalse(isAnagram(word, "tell"));
        assertFalse(isAnagram(word, "select"));
        assertFalse(isAnagram(word, "collect"));
        assertFalse(isAnagram(word, ""));
        assertFalse(isAnagram(word, null));
        assertFalse(isAnagram(word, "reter"));
    }
}