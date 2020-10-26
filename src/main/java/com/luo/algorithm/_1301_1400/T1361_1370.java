package com.luo.algorithm._1301_1400;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Luo Yuan Xin
 * @create 2020-10-26 16:35
 */
public class T1361_1370 {
    /**
     * 1361. 验证二叉树
     * 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
     * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
     * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
     * 注意：节点没有值，本问题中仅仅使用节点编号。
     * <p>
     * 示例 1：
     * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
     * 输出：true
     * <p>
     * 示例 2：
     * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
     * 输出：false
     * <p>
     * 示例 3：
     * 输入：n = 2, leftChild = [1,0], rightChild = [-1,-1]
     * 输出：false
     * <p>
     * 示例 4：
     * 输入：n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
     * 输出：false
     */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean visit[] = new boolean[n];
        boolean isroot[] = new boolean[n];
        //构建parent数组
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                if (!validateBinaryTreeNodesHelper(i, leftChild, rightChild, visit, isroot)) {
                    return false;
                } else {
                    isroot[i] = true;
                    visit[i] = false;
                }
            }
        }
        int count = 0;
        for (boolean val : visit) {
            if (!val) count++;
        }
        return count == 1;
    }

    private boolean validateBinaryTreeNodesHelper(int id, int[] leftChild,
                                                  int[] rightChild, boolean visit[], boolean isroot[]) {
        if (isroot[id]) {
            visit[id] = true;
            return true;
        }
        if (visit[id] == true)
            return false;
        visit[id] = true;
        if (leftChild[id] == -1 && rightChild[id] == -1) {
            return true;
        } else if (leftChild[id] == -1) {
            return validateBinaryTreeNodesHelper(rightChild[id], leftChild,
                    rightChild, visit, isroot);
        } else if (rightChild[id] == -1) {
            return validateBinaryTreeNodesHelper(leftChild[id], leftChild,
                    rightChild, visit, isroot);
        } else {
            return validateBinaryTreeNodesHelper(rightChild[id], leftChild,
                    rightChild, visit, isroot)
                    && validateBinaryTreeNodesHelper(leftChild[id], leftChild,
                    rightChild, visit, isroot);
        }
    }

    /**
     * 1362. 最接近的因数
     * 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
     * <p>
     * 两数乘积等于  num + 1 或 num + 2
     * 以绝对差进行度量，两数大小最接近
     * 你可以按任意顺序返回这两个整数。
     * <p>
     * 示例 1：
     * 输入：num = 8
     * 输出：[3,3]
     * 解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
     * <p>
     * 示例 2：
     * 输入：num = 123
     * 输出：[5,25]
     * <p>
     * 示例 3：
     * 输入：num = 999
     * 输出：[40,25]
     */
    public int[] closestDivisors(int num) {
        int i = (int) Math.sqrt(num) + 1;
        for (int index = i; index >= 0; index--) {
            if ((num + 1) % index == 0) {
                return new int[]{index, (num + 2) / index};
            }
            if ((num + 2) % index == 0) {
                return new int[]{index, (num + 2) / index};
            }
        }

        return new int[]{-1, -1};
    }

    /**
     * 1363. 形成三的最大倍数
     * 给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
     * 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
     * 如果无法得到答案，请返回一个空字符串。
     * <p>
     * 示例 1：
     * 输入：digits = [8,1,9]
     * 输出："981"
     * <p>
     * 示例 2：
     * 输入：digits = [8,6,7,1,0]
     * 输出："8760"
     * <p>
     * 示例 3：
     * 输入：digits = [1]
     * 输出：""
     * <p>
     * 示例 4：
     * 输入：digits = [0,0,0,0,0,0]
     * 输出："0"
     */
    public String largestMultipleOfThree(int[] digits) {
        int[] count = new int[10], mod = new int[3];
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
            count[digit]++;
            mod[digit % 3]++;
        }
        int removeMod = 0, rest = 0;
        if (sum % 3 == 1) {
            if (mod[1] >= 1) {
                removeMod = 1;
                rest = 1;
            } else {
                removeMod = 2;
                rest = 2;
            }
        } else if (sum % 3 == 2) {
            if (mod[2] >= 1) {
                removeMod = 2;
                rest = 1;
            } else {
                removeMod = 1;
                rest = 2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                if (rest > 0 && removeMod == i % 3) {
                    rest--;
                } else {
                    sb.append((char) (i + '0'));
                }
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb = new StringBuilder("0");
        }
        return sb.reverse().toString();
    }

    /**
     * 1365. 有多少小于当前数字的数字
     * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
     * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
     * 以数组形式返回答案。
     * <p>
     * 示例 1：
     * 输入：nums = [8,1,2,2,3]
     * 输出：[4,0,1,1,3]
     * 解释：
     * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
     * 对于 nums[1]=1 不存在比它小的数字。
     * 对于 nums[2]=2 存在一个比它小的数字：（1）。
     * 对于 nums[3]=2 存在一个比它小的数字：（1）。
     * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
     * <p>
     * 示例 2：
     * 输入：nums = [6,5,4,8]
     * 输出：[2,1,0,3]
     * <p>
     * 示例 3：
     * 输入：nums = [7,7,7,7]
     * 输出：[0,0,0,0]
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int pre = 0;
        int cur = 0;
        for (int i = 1; i < count.length; i++) {
            cur = count[i];
            count[i] = count[i - 1] + pre;
            pre = cur;
        }
        count[0] = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = count[nums[i]];
        }
        return res;
    }

    /**
     * 1366. 通过投票对团队排名
     * 现在有一个特殊的排名系统，依据参赛团队在投票人心中的次序进行排名，每个投票者都需要按从高到低的顺序对参与排名的所有团队进行排位。
     * 排名规则如下：
     * 参赛团队的排名次序依照其所获「排位第一」的票的多少决定。如果存在多个团队并列的情况，将继续考虑其「排位第二」的票的数量。以此类推，直到不再存在并列的情况。
     * 如果在考虑完所有投票情况后仍然出现并列现象，则根据团队字母的字母顺序进行排名。
     * 给你一个字符串数组 votes 代表全体投票者给出的排位情况，请你根据上述排名规则对所有参赛团队进行排名。
     * 请你返回能表示按排名系统 排序后 的所有团队排名的字符串。
     * <p>
     * 示例 1：
     * 输入：votes = ["ABC","ACB","ABC","ACB","ACB"]
     * 输出："ACB"
     * 解释：A 队获得五票「排位第一」，没有其他队获得「排位第一」，所以 A 队排名第一。
     * B 队获得两票「排位第二」，三票「排位第三」。
     * C 队获得三票「排位第二」，两票「排位第三」。
     * 由于 C 队「排位第二」的票数较多，所以 C 队排第二，B 队排第三。
     * <p>
     * 示例 2：
     * 输入：votes = ["WXYZ","XYZW"]
     * 输出："XWYZ"
     * 解释：X 队在并列僵局打破后成为排名第一的团队。X 队和 W 队的「排位第一」票数一样，但是 X 队有一票「排位第二」，而 W 没有获得「排位第二」。
     * <p>
     * 示例 3：
     * 输入：votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
     * 输出："ZMNAGUEDSJYLBOPHRQICWFXTVK"
     * 解释：只有一个投票者，所以排名完全按照他的意愿。
     * <p>
     * 示例 4：
     * 输入：votes = ["BCA","CAB","CBA","ABC","ACB","BAC"]
     * 输出："ABC"
     * 解释：
     * A 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
     * B 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
     * C 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
     * 完全并列，所以我们需要按照字母升序排名。
     * <p>
     * 示例 5：
     * 输入：votes = ["M","M","M","M"]
     * 输出："M"
     * 解释：只有 M 队参赛，所以它排名第一。
     */
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = votes[0].charAt(i) - 65;
        }
        int[][] memo = new int[26][n];
        for (String s : votes) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < n; i++) {
                memo[chars[i] - 65][i]++;
            }
        }
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                for (int i = 0; i < n; i++) {
                    if (memo[a][i] != memo[b][i]) {
                        return memo[b][i] - memo[a][i];
                    }
                }
                return a - b;
            }
        });
        StringBuilder ans = new StringBuilder();
        for (int i : nums) {
            ans.append((char) (65 + i));
        }
        return ans.toString();
    }

    /**
     * 1367. 二叉树中的列表
     * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
     * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
     * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
     * <p>
     * 示例 1：
     * 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
     * 输出：true
     * 解释：树中蓝色的节点构成了与链表对应的子路径。
     * <p>
     * 示例 2：
     * 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
     * 输出：true
     * <p>
     * 示例 3：
     * 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
     * 输出：false
     * 解释：二叉树中不存在一一对应链表的路径。
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        //先判断当前的节点，如果不对，再看左子树和右子树呗
        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean isSub(ListNode head, TreeNode node) {
        //特判：链表走完了，返回true
        if (head == null) {
            return true;
        }
        //特判：链表没走完，树走完了，这肯定不行，返回false
        if (node == null) {
            return false;
        }
        //如果值不同，必定不是啊
        if (head.val != node.val) {
            return false;
        }
        //如果值相同，继续看，左边和右边有一个满足即可
        return isSub(head.next, node.left) || isSub(head.next, node.right);
    }
}
