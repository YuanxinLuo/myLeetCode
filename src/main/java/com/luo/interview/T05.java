package com.luo.interview;

public class T05 {
    /**
     * 面试题 05.01. 插入
     * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
     * <p>
     * 示例1:
     * 输入：N = 10000000000, M = 10011, i = 2, j = 6
     * 输出：N = 10001001100
     * <p>
     * 示例2:
     * 输入： N = 0, M = 11111, i = 0, j = 4
     * 输出：N = 11111
     *
     * @param N
     * @param M
     * @param i
     * @param j
     * @return
     */
    public int insertBits(int N, int M, int i, int j) {
        int ans = 0, bit;
        M <<= i;
        for (int k = 0; k < 32; k++) {
            bit = (k >= i && k <= j) ? M & (1 << k) : N & (1 << k);
            ans += bit;
        }
        return ans;
    }

    /**
     * 面试题 05.03. 翻转数位
     * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
     * <p>
     * 示例 1：
     * 输入: num = 1775(110111011112)
     * 输出: 8
     * <p>
     * 示例 2：
     * 输入: num = 7(01112)
     * 输出: 4
     *
     * @param num
     * @return
     */
    public int reverseBits(int num) {
        int maxLen = 0, preLen = 0, curLen = 0, bits = 32;
        while (bits-- > 0) {
            if ((num & 1) == 0) {
                curLen -= preLen;
                preLen = curLen + 1;
            }
            curLen++;
            maxLen = Math.max(maxLen, curLen);
            num >>= 1;
        }
        return maxLen;
    }

    /**
     * 面试题 05.06. 整数转换
     * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
     * <p>
     * 示例1:
     * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
     * 输出：2
     * <p>
     * 示例2:
     * 输入：A = 1，B = 2
     * 输出：2
     *
     * @param A
     * @param B
     * @return
     */
    public int convertInteger(int A, int B) {
        int x = A ^ B, cnt = 0;
        while (x != 0) {
            x &= (x - 1);
            cnt++;
        }
        return cnt;
    }


    /**
     * 面试题 05.07. 配对交换
     * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
     * <p>
     * 示例1:
     * 输入：num = 2（或者0b10）
     * 输出 1 (或者 0b01)
     * <p>
     * 示例2:
     * 输入：num = 3
     * 输出：3
     *
     * @param num
     * @return
     */
    public int exchangeBits(int num) {
        return ((num & 0x55555555) << 1) | ((num & 0xaaaaaaaa) >> 1);
    }
}
