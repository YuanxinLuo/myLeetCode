package com.luo.algorithm._401_500;


public class T481_490 {
    /**
     * 482. 密钥格式化
     * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
     * 给你一个数字 K，请你重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符；而第一个分组中，至少要包含 1 个字符。
     * 两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
     * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
     * <p>
     * 示例 1：
     * 输入：S = "5F3Z-2e-9-w", K = 4
     * 输出："5F3Z-2E9W"
     * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
     * 注意，两个额外的破折号需要删掉。
     * <p>
     * 示例 2：
     * 输入：S = "2-5g-3-J", K = 2
     * 输出："2-5G-3J"
     * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
     */
    public String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toCharArray();
        char[] result = new char[chars.length + S.length() / K];
        int length = 0;
        int i = chars.length - 1, j = result.length - 1;
        for (; i >= 0; ) {
            if (chars[i] == '-') {
                i--;
                continue;
            }
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            }
            if (length != K) {
                result[j] = chars[i];
                length++;
                if (i == 0) {
                    j--;
                    break;
                } else {
                    j--;
                    i--;
                }
            } else {
                length = 1;
                result[j] = '-';
                result[j - 1] = chars[i];
                j -= 2;
                i--;

            }
        }
        return new String(result, j + 1, result.length - j - 1);
    }

    /**
     * 485. 最大连续1的个数
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     * <p>
     * 示例 1:
     * 输入: [1,1,0,1,1,1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0,j = 0;
        int count = 0;
        while(j < nums.length){
            if(nums[j] == 0){
                count = Math.max(count,j - i);
                i = j + 1;
            }
            j++;
        }
        return Math.max(count,j - i);
    }

    /**
     * 486. 预测赢家
     * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。
     * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
     * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
     * <p>
     * 示例 1：
     * 输入：[1, 5, 2]
     * 输出：False
     * 解释：一开始，玩家1可以从1和2中进行选择。
     * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
     * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
     * 因此，玩家 1 永远不会成为赢家，返回 False 。
     * <p>
     * 示例 2：
     * 输入：[1, 5, 233, 7]
     * 输出：True
     * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
     * 最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
     */
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] >= 0;
    }
}
