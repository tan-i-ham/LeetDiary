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
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        ans = root.val;
        nonSplitMax(root);
        return ans;
    }
    
    public int nonSplitMax(TreeNode node){
        if(node==null){
            return 0;
        }
        if(node.left==null && node.right ==null){
            ans = Math.max(ans, node.val);
            return node.val;
        }
        int l = nonSplitMax(node.left);
        int r = nonSplitMax(node.right);
        
        ans = Math.max(ans, node.val + l + r);
        // System.out.println(ans);
        int currNonSplit = Math.max(l, r);
        int currAns = node.val;
        ans = Math.max(ans, node.val);
        if(currNonSplit > 0){
            currAns += currNonSplit;
        }
        ans = Math.max(ans, currAns);
        return currAns;
    }
}