class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        // If the trees match starting from the current node, return true
        if (isSameTree(root, subRoot)) {
            return true;
        }
        // Otherwise, recursively check the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isSameTree(TreeNode s, TreeNode t) {
        // If both nodes are null, they match
        if (s == null && t == null) {
            return true;
        }
        // If only one is null or values don't match, they aren't the same
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        // Recursively check both left and right children
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}