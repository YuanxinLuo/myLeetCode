package com.luo.algorithm._501_600;

import org.junit.Test;

import java.util.Arrays;

public class Test521_530 {
    T521_530 t = new T521_530();

    @Test
    public void test529() {
        char[][] b1 = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        char[][] chars = t.updateBoard(b1, new int[]{3, 0});
        for (char[] c : chars) {
            System.out.println(Arrays.toString(c));
        }
        System.out.println("-----------------------------------------");
        char[][] b2 = {{'B', '1', 'E', '1', 'B'}, {'B', '1', 'M', '1', 'B'}, {'B', '1', '1', '1', 'B'}, {'B', 'B', 'B', 'B', 'B'}};
        char[][] chars2 = t.updateBoard(b2, new int[]{1, 2});
        for (char[] c : chars2) {
            System.out.println(Arrays.toString(c));
        }
    }
}
