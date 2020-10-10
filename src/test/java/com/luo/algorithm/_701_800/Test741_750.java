package com.luo.algorithm._701_800;

import org.junit.Test;

public class Test741_750 {
    T741_750 t = new T741_750();


    @Test
    public void test746() {
        System.out.println(t.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(t.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    @Test
    public void test747() {
        System.out.println(t.dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(t.dominantIndex(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void test748() {
        System.out.println(t.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(t.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
        System.out.println(t.shortestCompletingWord("Ah71752", new String[]{"suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"}));
        System.out.println(t.shortestCompletingWord("OgEu755", new String[]{"enough", "these", "play", "wide", "wonder", "box", "arrive", "money", "tax", "thus"}));
        System.out.println(t.shortestCompletingWord("iMSlpe4", new String[]{"claim", "consumer", "student", "camera", "public", "never", "wonder", "simple", "thought", "use"}));
    }

    @Test
    public void test749() {
        int[][] g1 = {{0, 1, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(t.containVirus(g1));
        int[][] g2 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(t.containVirus(g2));
        int[][] g3 = {{1, 1, 1, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(t.containVirus(g3));
    }

}
