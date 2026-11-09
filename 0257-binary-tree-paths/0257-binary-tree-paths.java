class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, "", paths);
        }
        return paths;
    }
    
    private void dfs(TreeNode node, String currentPath, List<String> paths) {
        currentPath += node.val;
        if (node.left == null && node.right == null) {
            paths.add(currentPath);
            return;
        }
        if (node.left != null) {
            dfs(node.left, currentPath + "->", paths);
        }
        if (node.right != null) {
            dfs(node.right, currentPath + "->", paths);
        }
    }
}