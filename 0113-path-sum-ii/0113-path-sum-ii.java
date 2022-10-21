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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        
        return ans;
    }
    public void helper(TreeNode node, int currSum, int targetSum, List<Integer> currPath) {
        
        if(node != null){
            currSum += node.val;
            currPath.add(node.val);
            if(node.left == null && node.right == null){
                if(currSum  == targetSum){
                    ans.add(new ArrayList<>(currPath));
                }
                currPath.remove(currPath.size()-1);
                return;
            }
            if(node.left != null){
                helper(node.left, currSum, targetSum, currPath);
            }
            if(node.right != null){
                helper(node.right, currSum, targetSum, currPath);
            }          
            currPath.remove(currPath.size()-1);
        }           
    }
}