package com.luo.algorithm._701_800;

import java.util.ArrayList;

public class T741_750 {
    /**
     * 745. 前缀和后缀搜索
     * 给定多个 words，words[i] 的权重为 i 。
     *
     * 设计一个类 WordFilter 实现函数WordFilter.f(String prefix, String suffix)。这个函数将返回具有前缀 prefix 和后缀suffix 的词的最大权重。如果没有这样的词，返回 -1。
     *
     * 例子:
     *
     * 输入:
     * WordFilter(["apple"])
     * WordFilter.f("a", "e") // 返回 0
     * WordFilter.f("b", "") // 返回 -1
     */
    public static class WordFilter {
        private class Trie {
            Trie[] next = new Trie[26];
            ArrayList<Integer> weights = new ArrayList<>();

            Trie(int weight) {
                weights.add(weight);
            }
        }

        Trie[] topForward = new Trie[26];
        Trie[] topBackward = new Trie[26];

        public WordFilter(String[] words) {
            int c;
            Trie[] current;
            for (int k = 0; k < words.length; k++) {
                String word = words[k];
                current = topForward;
                for (int i = 0; i < word.length(); i++) {
                    c = word.charAt(i) - 'a';
                    if (current[c] == null) {
                        current[c] = new Trie(k);
                    } else {
                        current[c].weights.add(k);
                    }
                    current = current[c].next;
                }
                current = topBackward;
                for (int i = word.length() - 1; i >= 0; i--) {
                    c = word.charAt(i) - 'a';
                    if (current[c] == null) {
                        current[c] = new Trie(k);
                    } else {
                        current[c].weights.add(k);
                    }
                    current = current[c].next;
                }
            }
        }

        private static final ArrayList<Integer> EMPTY = new ArrayList<>();

        public int f(String prefix, String suffix) {
            int c;
            ArrayList<Integer> prefixWeight = EMPTY, suffixWeight = EMPTY;
            Trie[] current = topForward;
            for (int i = 0; i < prefix.length(); i++) {
                c = prefix.charAt(i) - 'a';
                if (current[c] == null) {
                    return -1;
                } else {
                    prefixWeight = current[c].weights;
                    current = current[c].next;
                }
            }
            current = topBackward;
            for (int i = suffix.length() - 1; i >= 0; i--) {
                c = suffix.charAt(i) - 'a';
                if (current[c] == null) {
                    return -1;
                } else {
                    suffixWeight = current[c].weights;
                    current = current[c].next;
                }
            }
            int preIndex = prefixWeight.size() - 1, sufIndex = suffixWeight.size() - 1, p, s;
            while (preIndex >= 0 && sufIndex >= 0) {
                p = prefixWeight.get(preIndex);
                s = suffixWeight.get(sufIndex);
                if (p < s) sufIndex--;
                else if (p > s) preIndex--;
                else return p;
            }
            return -1;
        }
    }
    /**
     * 746. 使用最小花费爬楼梯
     * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
     * <p>
     * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     * <p>
     * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
     * <p>
     * 示例 1:
     * <p>
     * 输入: cost = [10, 15, 20]
     * 输出: 15
     * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
     * <p>
     * 示例 2:
     * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * 输出: 6
     * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
     */
    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

    /**
     * 747. 至少是其他数字两倍的最大数
     * 在一个给定的数组nums中，总是存在一个最大元素 。
     * <p>
     * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
     * <p>
     * 如果是，则返回最大元素的索引，否则返回-1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [3, 6, 1, 0]
     * 输出: 1
     * 解释: 6是最大的整数, 对于数组中的其他整数,
     * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
     * <p>
     * <p>
     * 示例 2:
     * 输入: nums = [1, 2, 3, 4]
     * 输出: -1
     * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
     */
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }

    /**
     * 748. 最短补全词
     * 给定一个字符串牌照 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
     * <p>
     * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为 补全词 。在所有完整词中，最短的单词我们称之为 最短补全词 。
     * <p>
     * 单词在匹配牌照中的字母时要：
     * <p>
     * 忽略牌照中的数字和空格。
     * 不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
     * 如果某个字母在牌照中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
     * 例如：licensePlate = "aBc 12c"，那么它由字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 是 "abccdef"、"caaacab" 以及 "cbca" 。
     * <p>
     * 题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取单词列表中最靠前的一个。
     * <p>
     * 示例 1：
     * <p>
     * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
     * 输出："steps"
     * 说明：最短补全词应该包括 "s"、"p"、"s" 以及 "t"。在匹配过程中我们忽略牌照中的大小写。
     * "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
     * "steps" 包含 "t"、"p" 和两个 "s"。
     * "stripe" 缺一个 "s"。
     * "stepple" 缺一个 "s"。
     * 因此，"steps" 是唯一一个包含所有字母的单词，也是本样例的答案。
     * <p>
     * 示例 2：
     * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
     * 输出："pest"
     * 说明：存在 3 个包含字母 "s" 且有着最短长度的补全词，"pest"、"stew"、和 "show" 三者长度相同，但我们返回最先出现的补全词 "pest" 。
     * <p>
     * 示例 3：
     * 输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy","education","drug","prevent","writer","old"]
     * 输出："husband"
     * <p>
     * 示例 4：
     * 输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder","box","arrive","money","tax","thus"]
     * 输出："enough"
     * <p>
     * 示例 5：
     * 输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","public","never","wonder","simple","thought","use"]
     * 输出："simple"
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = count(licensePlate);
        String ans = "";
        for (String word : words)
            if ((word.length() < ans.length() || ans.length() == 0) &&
                    dominates(count(word.toLowerCase()), target))
                ans = word;
        return ans;
    }

    private boolean dominates(int[] count1, int[] count2) {
        for (int i = 0; i < 26; ++i)
            if (count1[i] < count2[i])
                return false;
        return true;
    }

    private int[] count(String word) {
        int[] ans = new int[26];
        for (char letter : word.toCharArray()) {
            int index = Character.toLowerCase(letter) - 'a';
            if (0 <= index && index < 26)
                ans[index]++;
        }
        return ans;
    }

    /**
     * 749. 隔离病毒
     * 病毒扩散得很快，现在你的任务是尽可能地通过安装防火墙来隔离病毒。
     * <p>
     * 假设世界由二维矩阵组成，0 表示该区域未感染病毒，而 1 表示该区域已感染病毒。可以在任意 2 个四方向相邻单元之间的共享边界上安装一个防火墙（并且只有一个防火墙）。
     * <p>
     * 每天晚上，病毒会从被感染区域向相邻未感染区域扩散，除非被防火墙隔离。现由于资源有限，每天你只能安装一系列防火墙来隔离其中一个被病毒感染的区域（一个区域或连续的一片区域），且该感染区域对未感染区域的威胁最大且保证唯一。
     * <p>
     * 你需要努力使得最后有部分区域不被病毒感染，如果可以成功，那么返回需要使用的防火墙个数; 如果无法实现，则返回在世界被病毒全部感染时已安装的防火墙个数。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入: grid =
     * [[0,1,0,0,0,0,0,1],
     * [0,1,0,0,0,0,0,1],
     * [0,0,0,0,0,0,0,1],
     * [0,0,0,0,0,0,0,0]]
     * 输出: 10
     * 说明:
     * 一共有两块被病毒感染的区域: 从左往右第一块需要 5 个防火墙，同时若该区域不隔离，晚上将感染 5 个未感染区域（即被威胁的未感染区域个数为 5）;
     * 第二块需要 4 个防火墙，同理被威胁的未感染区域个数是 4。因此，第一天先隔离左边的感染区域，经过一晚后，病毒传播后世界如下:
     * [[0,1,0,0,0,0,1,1],
     * [0,1,0,0,0,0,1,1],
     * [0,0,0,0,0,0,1,1],
     * [0,0,0,0,0,0,0,1]]
     * 第二题，只剩下一块未隔离的被感染的连续区域，此时需要安装 5 个防火墙，且安装完毕后病毒隔离任务完成。
     * <p>
     * 示例 2：
     * <p>
     * 输入: grid =
     * [[1,1,1],
     * [1,0,1],
     * [1,1,1]]
     * 输出: 4
     * 说明:
     * 此时只需要安装 4 面防火墙，就有一小区域可以幸存，不被病毒感染。
     * 注意不需要在世界边界建立防火墙。
     * <p>
     * <p>
     * 示例 3:
     * 输入: grid =
     * [[1,1,1,0,0,0,0,0,0],
     * [1,0,1,0,1,1,1,1,1],
     * [1,1,1,0,0,0,0,0,0]]
     * 输出: 13
     * 说明:
     * 在隔离右边感染区域后，隔离左边病毒区域只需要 2 个防火墙了。
     */
    public int containVirus(int[][] grid) {
        int result=0;
        while (true){
            int walls=process(grid);
            if (walls==0){
                break;
            }
            result+=walls;
        }
        return result;
    }

    //对整个场景进行业务逻辑梳理
    private int process(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // cnt 是最大面积，ans是对应的墙
        int cnt = 0, res = 0, color = -1, row = -1, col = -1;
        //用一个数组来装当前这个点的状态
        int[][] stateArray=new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j]==1&&stateArray[i][j]==0){
                    Wall wall = new Wall();
                    wall.walls=0;
                    int maxArea = getMaxAreaDfs(grid, stateArray, i, j, color, wall);
                    if(maxArea>cnt){
                        cnt=maxArea;
                        res=wall.walls;
                        row=i;
                        col=j;
                    }
                    color--;
                }
            }
        }
        //修墙，将目标区域设置为未活动
        buildWall(grid,row,col);
        //另一块传播病毒
        //spread(grid,stateArray,row,col);
        stateArray=new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && stateArray[i][j] == 0){
                    spread(grid, stateArray, i, j);
                }
            }
        }
        return res;

    }

    private void spread(int[][] grid, int[][] stateArray, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || stateArray[row][col] == 1) {
            return;
        }
        if (grid[row][col] == 0){
            grid[row][col] = 1;
            stateArray[row][col] = 1;
        }else if (grid[row][col] == 1){
            stateArray[row][col] = 1;
            int[] dir = { -1, 0, 1, 0, -1 };
            for (int i = 0; i < 4; i++){
                spread(grid, stateArray, row + dir[i], col + dir[i + 1]);
            }
        }
    }

    private void buildWall(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != 1){
            return;
        }
        //设置为不活动
        grid[row][col] = -1;
        int[] dir = { -1, 0, 1, 0, -1 };
        //DFS
        for (int i = 0; i < 4; i++){
            buildWall(grid, row + dir[i], col + dir[i + 1]);
        }
    }

    private int getMaxAreaDfs(int[][] grid, int[][] stateArray, int row, int col, int color, Wall wall) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        //异常排除
        if (row < 0 || row >= rows || col < 0 || col >= cols){
            return 0;
        }
        //0不是病毒
        if (grid[row][col] == 0) {
            wall.walls++;
            //第二次进入
            if (stateArray[row][col] == color){
                return 0;
            }
            //第一次进入
            stateArray[row][col] = color;
            return 1;
        }
        // 不是grid[i][j]==1 or 0
        if (stateArray[row][col] == 1 || grid[row][col] != 1){
            return 0;
        }
        //grid[i][j]==1
        stateArray[row][col] = 1;
        //前后左右,再来一次，直到出现不再是1的结果。DFS的思想。
        int[] dir = { -1, 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++){
            res += getMaxAreaDfs(grid,stateArray, row + dir[i], col + dir[i + 1], color, wall);
        }
        return res;
    }

    class Wall{
        public int walls;
    }
}
