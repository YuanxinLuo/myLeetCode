package com.luo.algorithm._701_800;

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
    public void test844() {
        System.out.println(t.backspaceCompare("ab#c", "ad#c"));
        System.out.println(t.backspaceCompare("ab##", "c#d#"));
        System.out.println(t.backspaceCompare("a##c", "#a#c"));
        System.out.println(t.backspaceCompare("a#c", "b"));
    }

    @Test
    public void test849() {
        System.out.println(t.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(t.maxDistToClosest(new int[]{1, 0, 0, 0}));
    }
}
