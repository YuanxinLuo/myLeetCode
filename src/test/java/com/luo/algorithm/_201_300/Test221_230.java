package com.luo.algorithm._201_300;

import org.junit.Test;

public class Test221_230 {
    T221_230 t = new T221_230();

    @Test
    public void test221() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '0'},
        };

        System.out.println(t.maximalSquare(matrix));
        char[][] matrix2 = {
                {'1', '0', '1', '0', '0'},
                {'1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '0'},
                {'1', '0', '1', '1', '0'},
        };
        System.out.println(t.maximalSquare(matrix2));
    }
}
