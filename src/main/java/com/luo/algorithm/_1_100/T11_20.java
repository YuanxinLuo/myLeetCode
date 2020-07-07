package com.luo.algorithm._1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class T11_20 {
    /**
     * 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     */
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - 1);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }

    /**
     * 13. 罗马数字转整数
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "III"
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: "IV"
     * 输出: 4
     * 示例 3:
     * <p>
     * 输入: "IX"
     * 输出: 9
     * 示例 4:
     * <p>
     * 输入: "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例 5:
     * <p>
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * @param s 罗马数组
     * @return 整型数字
     */
    public int romanToInt(String s) {
        int v = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    v += 1;
                    break;
                case 'V':
                    v += 5;
                    break;
                case 'X':
                    v += 10;
                    break;
                case 'L':
                    v += 50;
                    break;
                case 'C':
                    v += 100;
                    break;
                case 'D':
                    v += 500;
                    break;
                case 'M':
                    v += 1000;
                    break;
            }
            if (i != 0) {
                char c2 = s.charAt(i - 1);
                if ((c == 'V' || c == 'X') && c2 == 'I') v = v - 1 * 2;
                if ((c == 'L' || c == 'C') && c2 == 'X') v = v - 10 * 2;
                if ((c == 'D' || c == 'M') && c2 == 'C') v = v - 100 * 2;
            }
        }
        return v;
    }

    /**
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (String str : strs) {
            while (str.indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

    /**
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 示例：
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int third = n - 1;
            int target = -nums[i];
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                while (j < third && nums[j] + nums[third] > target) {
                    --third;
                }
                if (j == third) break;
                if (nums[j] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    /**
     * 16. 最接近的三数之和
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * 示例：
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     */
    public int threeSumClosest(int[] nums, int target) {
        // 初始化 ans 为边界值，表示离 target 最远的和。
        int ans = Integer.MIN_VALUE;
        int len = nums.length;
        if (len < 3) {
            throw new IllegalArgumentException("数组元素不够三个！");
        }
        // 对数组排序，方便双指针移动。
        Arrays.sort(nums);
        // 判断 target 如果在数组和的边界之外则直接返回边界值。
        if (target <= nums[0] + nums[1] + nums[2]) {
            return nums[0] + nums[1] + nums[2];
        } else if (target >= nums[len - 1] + nums[len - 2] + nums[len - 3]) {
            return nums[len - 1] + nums[len - 2] + nums[len - 3];
        }
        // 循环固定第一个数，根据双指针从它之后去选择另外两个数。
        for (int i = 0; i < len - 2; i++) {
            // 相同的第一个数只固定一次，避免重复运算。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1, R = len - 1;
            while (L < R) {
                // 判断当前循环能得到的最小三数和。
                int min = nums[i] + nums[L] + nums[L + 1];
                if (target < min) {
                    if (Math.abs(ans - target) > Math.abs(min - target)) {
                        ans = min;
                    }
                    break;
                }
                // 判断当前循环能得到的最大三数和。
                int max = nums[i] + nums[R] + nums[R - 1];
                if (target > max) {
                    if (Math.abs(ans - target) > Math.abs(max - target)) {
                        ans = max;
                    }
                    break;
                }
                int sum = nums[i] + nums[L] + nums[R];
                // 如果三数之和等于 target 则直接返回。
                if (sum == target) {
                    return sum;
                }
                // 根据差的绝对值判断离 target 最近的和。
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                // 根据三数之和与 target 大小的比较来移动俩指针。
                if (sum > target) {
                    R--;
                    while (L < R && nums[R + 1] == nums[R]) {
                        R--;
                    }
                } else {
                    L++;
                    while (L < R && nums[L - 1] == nums[L]) {
                        L++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * 输入: "()"
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     * <p>
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     * <p>
     * 示例 4:
     * 输入: "([)]"
     * 输出: false
     * <p>
     * 示例 5:
     * 输入: "{[]}"
     * 输出: true
     *
     * @param s 字符串
     * @return 是否有效
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
