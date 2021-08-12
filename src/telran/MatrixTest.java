package telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest extends Matrix {

    int[][] matrix1 = {{1, 2, 3}};
    int[][] matrix2 = {{1}, {2}, {3}};
    int[][] multiMatrix = {{14}};

    int[][] matrix3 = {{1, 2, 3}, {4,5,6}};
    int[][] matrix4 = {{1,2}, {3,4}, {5,6}};
    int[][] multiMatrix2 = {{22,28}, {49,64}};


    @Test
    void testSumMatrix() {
        assertEquals(6, Matrix.sumMatrix(matrix1));
    }

    @Test
    void testTransMatrix() {
        assertArrayEquals(matrix2, Matrix.transMatrix(matrix1));
    }

    @Test
    void testMultiplyMatrix() {
        assertArrayEquals(multiMatrix, Matrix.multiplyMatrix(matrix1, matrix2));
    }

    @Test
    void testMultiplyMatrix2() {
        assertArrayEquals(multiMatrix2, Matrix.multiplyMatrix(matrix3, matrix4));
    }
}