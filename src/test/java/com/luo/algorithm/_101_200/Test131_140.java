package com.luo.algorithm._101_200;

import com.luo.offer.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test131_140 {
    T131_140 t = new T131_140();

    @Test
    public void test136() {
        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(t.singleNumber(nums1));
        System.out.println(t.singleNumber(nums2));
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
}
