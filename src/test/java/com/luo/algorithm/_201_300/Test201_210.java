package com.luo.algorithm._201_300;

import org.junit.Test;

import java.util.Arrays;


public class Test201_210 {
    T201_210 t = new T201_210();

    @Test
    public void test210() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(Arrays.toString(t.findOrder(numCourses, prerequisites)));

        numCourses = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(t.findOrder(numCourses, prerequisites2)));
    }

}
