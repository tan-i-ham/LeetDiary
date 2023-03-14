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
    public int sumNumbers(TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }
    public void dfs(TreeNode node, int currSum){
        if(node == null){
            return;
        }
        currSum = currSum*10 + node.val;
        if(node.left == null && node.right == null){
            ans += currSum;
            return;
        }
        if(node.left!=null){
            dfs(node.left, currSum);    
        }
        if(node.right!=null){
            dfs(node.right, currSum);    
        }
        
        
    }
}