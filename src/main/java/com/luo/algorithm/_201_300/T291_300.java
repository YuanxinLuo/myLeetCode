package com.luo.algorithm._201_300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T291_300 {

    /**
     * 297. 二叉树的序列化与反序列化
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     * 示例:
     * 你可以将以下二叉树：
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * <p>
     * 序列化为 "[1,2,3,null,null,4,5]"
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serialize(root, "");
        }

        private String serialize(TreeNode root, String str) {
            if (root == null) {
                str += "None,";
            } else {
                str += str.valueOf(root.val) + ",";
                str = serialize(root.left, str);
                str = serialize(root.right, str);
            }
            return str;
        }

        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            List<String> list = new LinkedList<>(Arrays.asList(arr));
            return deserialize(list);
        }

        private TreeNode deserialize(List<String> list) {
            if (list.get(0).equals("None")) {
                list.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left = deserialize(list);
            root.right = deserialize(list);
            return root;
        }
    }
}
