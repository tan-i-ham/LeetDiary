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
// by dfs helper funcition with extra max argument to keep ancestors' max value
class Solution {
    int count;
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        count = 0;
        dfs(root, root.val);
        return count;
    }
    
    public void dfs(TreeNode node, int maxInParents){
        if(node==null){
            return;
        }
        if(node.val >= maxInParents){
            count++;
        }
        int currMax =  Math.max(maxInParents, node.val);
        dfs(node.left, currMax);
        dfs(node.right, currMax);
    }
}

// TC: O(N)
// TC: O(N), avg: O(logN) the hieght