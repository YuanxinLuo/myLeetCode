package com.luo.algorithm._601_700;

public class T671_680 {
    /**
     * 679. 24 点游戏
     * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [4, 1, 8, 7]
     * 输出: True
     * 解释: (8-4) * (7-1) = 24
     * 示例 2:
     * <p>
     * 输入: [1, 2, 1, 2]
     * 输出: False
     */
    public boolean judgePoint24(int[] nums) {
        double a = nums[0];
        double b = nums[1];
        double c = nums[2];
        double d = nums[3];
        return judge(a, b, c, d);
    }

    public boolean judge(double a, double b, double c, double d) {
        return
                // a b
                judge(a + b, c, d) ||
                        judge(a * b, c, d) ||
                        judge(a - b, c, d) ||
                        judge(b - a, c, d) ||
                        judge(a / b, c, d) ||
                        judge(b / a, c, d) ||
                        // b c
                        judge(c + b, a, d) ||
                        judge(c * b, a, d) ||
                        judge(c - b, a, d) ||
                        judge(b - c, a, d) ||
                        judge(c / b, a, d) ||
                        judge(b / c, a, d) ||
                        // c d
                        judge(c + d, a, b) ||
                        judge(c * d, a, b) ||
                        judge(c - d, a, b) ||
                        judge(d - c, a, b) ||
                        judge(c / d, a, b) ||
                        judge(d / c, a, b) ||
                        // b d
                        judge(b + d, a, c) ||
                        judge(b * d, a, c) ||
                        judge(b - d, a, c) ||
                        judge(d - b, a, c) ||
                        judge(b / d, a, c) ||
                        judge(d / b, a, c) ||
                        // a c
                        judge(a + c, b, d) ||
                        judge(a * c, b, d) ||
                        judge(a - c, b, d) ||
                        judge(c - a, b, d) ||
                        judge(a / c, b, d) ||
                        judge(c / a, b, d) ||
                        // a d
                        judge(a + d, b, c) ||
                        judge(a * d, b, c) ||
                        judge(a - d, b, c) ||
                        judge(d - a, b, c) ||
                        judge(a / d, b, c) ||
                        judge(d / a, b, c);

    }

    public boolean judge(double a, double b, double c) {// 24 , 3 , 8
        return
                // a b
                judge(a + b, c) ||
                        judge(a * b, c) ||
                        judge(a - b, c) ||
                        judge(b - a, c) ||
                        judge(a / b, c) ||
                        judge(b / a, c) ||
                        // b c
                        judge(c + b, a) ||
                        judge(c * b, a) ||
                        judge(c - b, a) ||
                        judge(b - c, a) ||
                        judge(c / b, a) ||
                        judge(b / c, a) ||
                        // a c
                        judge(c + a, b) ||
                        judge(c * a, b) ||
                        judge(c - a, b) ||
                        judge(a - c, b) ||
                        judge(c / a, b) ||
                        judge(a / c, b);
    }

    public boolean judge(double a, double b) {
        return
                //注意精度
                Math.abs(a + b - 24) < 0.001 ||
                        Math.abs(a - b - 24) < 0.001 ||
                        Math.abs(b - a - 24) < 0.001 ||
                        Math.abs(a * b - 24) < 0.001 ||
                        Math.abs(a / b - 24) < 0.001 ||
                        Math.abs(b / a - 24) < 0.001;
    }

    /**
     * 680. 验证回文字符串 Ⅱ
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * 示例 1:
     * 输入: "aba"
     * 输出: True
     * <p>
     * 示例 2:
     * 输入: "abca"
     * 输出: True
     * 解释: 你可以删除c字符。
     *
     * @param s 非空字符串
     * @return 是否
     */
    public boolean validPalindrome(String s) {
        return valid(s, 0, s.length() - 1, false);
    }

    private boolean valid(String s, int i, int j, boolean isDeep) {
        while (i < j) {
            char a = s.charAt(i), b = s.charAt(j);
            if (a != b) {
                if (isDeep) return false;
                return valid(s, i, j - 1, true) || valid(s, i + 1, j, true);
            }
            i++;
            j--;
        }
        return true;
    }
}
