package com.luo.algorithm._101_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test131_140 {
    T131_140 t = new T131_140();

    @Test
    public void test131() {
        System.out.println(t.partition("aab"));
    }

    @Test
    public void test132() {
        System.out.println(t.minCut("aab"));
    }

    @Test
    public void test133() {
        System.out.println(t.cloneGraph(new Node()));
    }

    @Test
    public void test134() {
        System.out.println(t.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(t.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    @Test
    public void test135() {
        System.out.println(t.candy(new int[]{1, 0, 2}));
        System.out.println(t.candy(new int[]{1, 2, 2}));
    }

    @Test
    public void test136() {
        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(t.singleNumber(nums1));
        System.out.println(t.singleNumber(nums2));
    }

    @Test
    public void test137() {
        System.out.println(t.singleNumber2(new int[]{2, 2, 3, 2}));
        System.out.println(t.singleNumber2(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }

    @Test
    public void test139() {
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("leet");
        wordDict1.add("code");
        System.out.println(t.wordBreak("leetcode", wordDict1));

        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("apple");
        wordDict2.add("pen");
        System.out.println(t.wordBreak("applepenapple", wordDict2));

        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("cats");
        wordDict3.add("dog");
        wordDict3.add("sand");
        wordDict3.add("and");
        wordDict3.add("cat");
        System.out.println(t.wordBreak("catsandog", wordDict3));
    }

    @Test
    public void test140() {
        System.out.println(t.wordBreak140("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(t.wordBreak140("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(t.wordBreak140("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(t.wordBreak140("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));


    }
}
