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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.right != null){
                q.add(node.right);
            }
            if(node.left != null){
                q.add(node.left);
            }
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
        }
        return root;
    }
}
// TC: O(N)
// SC: O(logN) -> O(N)