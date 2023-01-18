/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        maxDepth(root);
        return ans - 1;
    }
    
    public int maxDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int l = maxDepth(node.left);
        int r = maxDepth(node.right);
        ans = Math.max(ans, 1 + l + r);
        return 1 + Math.max(l, r);
    }
    
}