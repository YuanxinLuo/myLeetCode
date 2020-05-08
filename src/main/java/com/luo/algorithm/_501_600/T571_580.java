package com.luo.algorithm._501_600;


public class T571_580 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        return isSubtreeFun(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubtreeFun(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s != null && t != null) {
            if (s.val != t.val) {
                return false;
            }
            return isSubtreeFun(s.left, t.left) && isSubtreeFun(s.right, t.right);
        } else {
            return false;
        }
    }
}
