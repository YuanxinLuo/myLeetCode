package com.luo.algorithm._301_400;

import java.util.Stack;

public class T391_400 {
    /**
     * 394. 字符串解码
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * <p>
     * 示例:
     * s = "3[a]2[bc]", 返回 "aaabcbc".
     * s = "3[a2[c]]", 返回 "accaccacc".
     * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = null;
        int i = 0;
        while (i < s.length()) {
            sb = new StringBuilder();
            while (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i++));
            }
            if (sb.length() > 0) {
                stack.push(sb.toString());
                stack.push(String.valueOf(s.charAt(i++)));
                continue;
            }
            while (i < s.length() && Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i++));
            }
            if (sb.length() > 0) {
                stack.push(sb.toString());
            }
            if (i < s.length() && s.charAt(i) == ']') {
                i++;
                sb = new StringBuilder();
                String subStr = stack.pop();
                while (!subStr.equals("[")) {
                    sb.insert(0, subStr);
                    subStr = stack.pop();
                }
                String str = sb.toString();
                int time = Integer.parseInt(stack.pop());
                for (int j = 0; j < time - 1; j++) {
                    sb.append(str);
                }
                stack.push(sb.toString());
            }
        }
        sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
