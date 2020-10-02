package com.luo.algorithm._701_800;

import org.junit.Test;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-02 20:22
 */
public class Test771_780 {
    T771_780 t = new T771_780();

    @Test
    public void test771() {
        System.out.println(t.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(t.numJewelsInStones("z", "ZZ"));
    }

    @Test
    public void test772() {
        System.out.println(t.slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
        System.out.println(t.slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}}));
        System.out.println(t.slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));
        System.out.println(t.slidingPuzzle(new int[][]{{3, 2, 4}, {1, 5, 0}}));
    }

    @Test
    public void test775() {
        System.out.println(t.isIdealPermutation(new int[]{1, 0, 2}));
        System.out.println(t.isIdealPermutation(new int[]{1, 2, 0}));
    }

    @Test
    public void test777() {
        System.out.println(t.canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }

    @Test
    public void test778() {
        System.out.println(t.swimInWater(new int[][]{{0, 2}, {1, 3}}));
        System.out.println(t.swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
    }

    @Test
    public void test779() {
        System.out.println(t.kthGrammar(1, 1));
        System.out.println(t.kthGrammar(2, 1));
        System.out.println(t.kthGrammar(2, 2));
        System.out.println(t.kthGrammar(4, 5));
    }

    @Test
    public void test780() {
        System.out.println(t.reachingPoints(1, 1, 3, 5));
        System.out.println(t.reachingPoints(1, 1, 2, 2));
        System.out.println(t.reachingPoints(1, 1, 1, 1));
    }
}
