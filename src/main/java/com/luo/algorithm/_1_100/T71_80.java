package com.luo.algorithm._1_100;

public class T71_80 {

    /**
     * 76. 最小覆盖子串
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
     * <p>
     * 示例：
     * <p>
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     *
     * @param s 字符串
     * @param t 字符串
     * @return 包含 T 所有字符的最小子串
     */
    public String minWindow(String s, String t) {
        // new一个256位的数组
        int[] count = new int[123];
        // 统计t中所有字符
        for(char c : t.toCharArray()){
            count[c] ++;
        }
        // len是t中char有几种
        int len = 0;
        for(int i : count){
            if(i != 0){
                len++;
            }
        }
        int p1 = 0, p2 = 0;
        int a1 = 0, a2 = s.length( )+ 1;
        char[] chars = s.toCharArray();
        while(p2 < chars.length){
            count[chars[p2]]--;
            if(count[chars[p2]] == 0){
                len--;
            }
            p2++;
            if(len == 0){
                while( p1 < p2 && count[chars[p1]] < 0){
                    count[chars[p1]]++;
                    p1++;
                }
                if( p2 - p1 < a2-a1){
                    a2 = p2;
                    a1 = p1;
                }
            }

        }
        return a2-a1>s.length()? "" :s.substring(a1,a2);
    }
}
