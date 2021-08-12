package telran;

public class Matrix {


    public static int sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int[][] transMatrix(int[][] matrix) {
        int[][] temp = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j][i] = matrix[i][j];
            }
        }
        return temp;
    }

    int[][] m1 = {
            {1, 2, 3}
            };
    int[][] m2 = {
            {1},
            {2},
            {3}
            };

    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int m1Str = matrix1.length; //(1)
        int m2Col = matrix2[0].length; // (1)
        int m2Str = matrix2.length; // (3)
        System.out.println(m1Str);
        int[][] res = new int[m1Str][m2Col];

        for (int i = 0; i < m1Str; i++) { // 1
            for (int j = 0; j < m2Col; j++) { // 1
                for (int k = 0; k < m2Str; k++) { // 3
                    res[i][j] += matrix1[i][k] * matrix2[k][j]; // res[1][1] = 1*1 + 2*2 + 3*3
                }
            }
        }
        return res;
    }

}
