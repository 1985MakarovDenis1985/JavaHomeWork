package memory.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import memory.service.MemoryService;

class MemoryServiceTest {

    @Test
    void testGetMaxAvailableMemory() {
        int[] arr;
        int maxMemory = MemoryService.getMaxAvailableMemory();
        boolean flag;
        try {
            arr = new int[maxMemory];
            flag = true;
        } catch (Throwable e) {
            flag = false;
        }
        assertTrue(flag);
        try {
            arr = new int[maxMemory + 1];
            flag = true;
        } catch (Throwable e) {
            flag = false;
        }
        assertFalse(flag);

    }

}
