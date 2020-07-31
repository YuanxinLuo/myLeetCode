package com.luo.algorithm._301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class T341_350 {

    /**
     * 341. 扁平化嵌套列表迭代器
     * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
     * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
     * <p>
     * 示例 1:
     * 输入: [[1,1],2,[1,1]]
     * 输出: [1,1,2,1,1]
     * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
     * <p>
     * 示例 2:
     * 输入: [1,[4,[6]]]
     * 输出: [1,4,6]
     * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
     */
    public class NestedIterator implements Iterator<Integer> {
        private List<Integer> list;
        private int index;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = integerIterator(nestedList);
            index = -1;
        }

        @Override
        public Integer next() {
            if (this.hasNext()) return list.get(++index);
            return null;
        }

        @Override
        public boolean hasNext() {
            if (index + 1 < list.size()) return true;
            return false;
        }

        private List<Integer> integerIterator(List<NestedInteger> nestedIntegerList) {
            ArrayList<Integer> list = new ArrayList<>(nestedIntegerList.size());
            for (NestedInteger tmp : nestedIntegerList) {
                if (tmp.isInteger())
                    list.add(tmp.getInteger());
                else
                    list.addAll(integerIterator(tmp.getList()));
            }
            return list;

        }
    }

    /**
     * 342. 4的幂
     * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
     * <p>
     * 示例 1:
     * 输入: 16
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: 5
     * 输出: false
     */
    public boolean isPowerOfFour(int num) {
        if (num == 0) return false;
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }

    /**
     * 343. 整数拆分
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
     * 返回你可以获得的最大乘积。
     * 示例 1:
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     * <p>
     * 示例 2:
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     */
    public int integerBreak(int n) {
        if (n <= 3)
            return n - 1;
        int x = n / 3, y = n % 3;
        //整除属于情况1，直接返回3的x次方
        if (y == 0) return (int) Math.pow(3, x);
        //余数为1属于情况2，相当于余数是4=2*2组合，返回3的x-1次方*2*2
        if (y == 1) return (int) Math.pow(3, x - 1) * 4;
        //余数是2属于情况3，直接返回3和2的组合
        return (int) (Math.pow(3, x) * 2);
    }

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
