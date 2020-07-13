package com.luo.algorithm._301_400;

import java.util.Arrays;

public class T341_350 {

    /**
     * 345. 反转字符串中的元音字母
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     * <p>
     * 示例 1:
     * 输入: "hello"
     * 输出: "holle"
     * <p>
     * 示例 2:
     * 输入: "leetcode"
     * 输出: "leotcede"
     */
    public String reverseVowels(String s) {
// 先将字符串转成字符数组（方便操作）
        // 以上是只针对 Java 语言来说的 因为 chatAt(i) 每次都要检查是否越界 有性能消耗
        char[] arr = s.toCharArray();
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            // 从左判断如果当前元素不是元音
            while (l < n && !isVowel(arr[l])) {
                l++;
            }
            // 从右判断如果当前元素不是元音
            while (r >= 0 && !isVowel(arr[r])) {
                r--;
            }
            // 如果没有元音
            if (l >= r) {
                break;
            }
            // 交换前后的元音
            swap(arr, l, r);
            // 这里要分开写，不要写进数组里面去
            l++;
            r--;
        }
        // 最后返回的时候要转换成字符串输出
        return new String(arr);
    }

    private void swap(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    // 判断是不是元音，如果不是元音才返回 true
    private boolean isVowel(char ch) {
        // 这里要直接用 return 语句返回，不要返回 true 或者 false
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    /**
     * 349. 两个数组的交集
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1：
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     * <p>
     * 示例 2：
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     */
    public int[] intersection(int[] nums1, int[] nums2) {
//        HashSet<Integer> set1 = new HashSet<Integer>();
//        for (Integer n : nums1) set1.add(n);
//        HashSet<Integer> set2 = new HashSet<Integer>();
//        for (Integer n : nums2) set2.add(n);
//
//        set1.retainAll(set2);
//
//        int[] output = new int[set1.size()];
//        int idx = 0;
//        for (int s : set1) output[idx++] = s;
//        return output;
        final int SIZE = 1000;
        boolean[] num = new boolean[SIZE];
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int cnt = 0;
        for (int i = 0; i < nums1.length; i++) {
            num[nums1[i]] = true;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (num[nums2[i]]) {
                result[cnt] = nums2[i];
                cnt++;
                num[nums2[i]] = false;
            }
        }
        int[] a = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            a[i] = result[i];
        }
        return a;
    }

    /**
     * 350. 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1:
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * <p>
     * 示例 2:
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] intersection = new int[Math.min(len1, len2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
