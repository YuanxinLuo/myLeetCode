package com.luo.algorithm._401_500;

public class T401_410 {

    /**
     * 406. 根据身高重建队列
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
     * <p>
     * 注意：
     * 总人数少于1100人。
     * <p>
     * 示例
     * 输入:
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     * 输出:
     * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     */
    public int[][] reconstructQueue(int[][] people) {
        sort(people, 0, people.length - 1);
        for (int i = people.length - 2; i >= 0; i--) {
            int[] curr = people[i];
            if (curr[1] > 0) {
                shiftBack(people, i, curr[1]);
            }
        }

        return people;
    }
    private void shiftBack(int[][] arr, int pos, int shift) {
        int[] tmp = arr[pos];
        System.arraycopy(arr, pos + 1, arr, pos, shift);
        arr[pos + shift] = tmp;
    }

    private void sort(int[][] arr, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int[] base = arr[lo];
        int pivot = lo;
        for (int i = lo + 1; i <= hi; i++) {
            int[] t = arr[i];
            if (t[0] < base[0] || t[0] == base[0] && t[1] >= base[1]) {
                swap(arr, ++pivot, i);
            }
        }
        swap(arr, pivot, lo);
        sort(arr, lo, pivot - 1);
        sort(arr, pivot + 1, hi);
    }

    private void swap(int[][] arr, int from, int to) {
        if (from == to) {
            return;
        }
        int[] tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }
    /**
     * 409. 最长回文串
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * 注意:
     * 假设字符串的长度不会超过 1010。
     * 示例 1:
     * 输入:
     * "abccccdd"
     * 输出:
     * 7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     */
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }

    /**
     * 410. 分割数组的最大值
     * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
     * <p>
     * 注意:
     * 数组长度 n 满足以下条件:
     * <p>
     * 1 ≤ n ≤ 1000
     * 1 ≤ m ≤ min(50, n)
     * 示例:
     * 输入:
     * nums = [7,2,5,10,8]
     * m = 2
     * 输出:
     * 18
     * <p>
     * 解释:
     * 一共有四种方法将nums分割为2个子数组。
     * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
     * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
     */
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int splits = split(nums, mid);
            if (splits > m)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int split(int[] nums, int maxIntervalSum) {
        int splits = 1;
        int curSum = 0;
        for (int num : nums) {
            if (curSum + num > maxIntervalSum) {
                curSum = 0;
                splits++;
            }
            curSum += num;
        }
        return splits;
    }
}
