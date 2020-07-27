package com.luo.algorithm._301_400;

import org.junit.Test;

public class Test391_400 {
    T391_400 t = new T391_400();

    @Test
    public void test392() {
        System.out.println(t.isSubsequence("abc", "ahbgdc"));
        System.out.println(t.isSubsequence("axc", "ahbgdc"));
    }

    @Test
    public void test393() {
        System.out.println(t.validUtf8(new int[]{197, 130, 1}));
        System.out.println(t.validUtf8(new int[]{235, 140, 4}));
    }

    @Test
    public void test394() {
        System.out.println(t.decodeString("3[a]2[bc]"));
        System.out.println(t.decodeString("3[a2[c]]"));
        System.out.println(t.decodeString("2[abc]3[cd]ef"));
    }

    @Test
    public void test395() {
        System.out.println(t.longestSubstring("aaabb", 3));
        System.out.println(t.longestSubstring("ababb",2));
    }
}
