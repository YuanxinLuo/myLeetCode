package com.luo.algorithm._201_300;

import org.junit.Test;

public class Test291_300 {

    T291_300 t = new T291_300();

    @Test
    public void test297() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        T291_300.Codec codec = t.new Codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize);
    }

}
