package com.luo.algorithm._801_900;

import com.luo.algorithm._801_900.T841_850;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test841_850 {
    T841_850 t = new T841_850();

    @Test
    public void test841() {
        List<List<Integer>> i1 = Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList());
        System.out.println(t.canVisitAllRooms(i1));
        List<List<Integer>> i2 = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList(0));
        System.out.println(t.canVisitAllRooms(i2));
    }

    @Test
    public void test842() {
        System.out.println(t.splitIntoFibonacci("123456579"));
        System.out.println(t.splitIntoFibonacci("11235813"));
        System.out.println(t.splitIntoFibonacci("112358130"));
        System.out.println(t.splitIntoFibonacci("0123"));
        System.out.println(t.splitIntoFibonacci("1101111"));
    }

    @Test
    public void test844() {
        System.out.println(t.backspaceCompare("ab#c", "ad#c"));
        System.out.println(t.backspaceCompare("ab##", "c#d#"));
        System.out.println(t.backspaceCompare("a##c", "#a#c"));
        System.out.println(t.backspaceCompare("a#c", "b"));
    }

    @Test
    public void test845() {
        System.out.println(t.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
        System.out.println(t.longestMountain(new int[]{2, 2, 2}));
    }

    @Test
    public void test846() {
        System.out.println(t.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(t.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }

    @Test
    public void test847() {
        System.out.println(t.shortestPathLength(new int[][]{{1, 2, 3}, {0}, {0}, {0}}));
        System.out.println(t.shortestPathLength(new int[][]{{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}}));
    }

    @Test
    public void test848() {
        System.out.println(t.shiftingLetters("abc", new int[]{3, 5, 9}));
    }

    @Test
    public void test849() {
        System.out.println(t.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(t.maxDistToClosest(new int[]{1, 0, 0, 0}));
    }

    @Test
    public void test850() {
        System.out.println(t.rectangleArea(new int[][]{{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}}));
        System.out.println(t.rectangleArea(new int[][]{{0, 0, 1000000000, 1000000000}}));
    }
}
