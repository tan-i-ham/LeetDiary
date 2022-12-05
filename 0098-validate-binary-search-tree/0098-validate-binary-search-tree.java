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
    Integer prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }
    public boolean inorder(TreeNode node) {
        if(node==null){
            return true;
        }

        if(!inorder(node.left)){
            return false;
        }
        
        if(prev !=null && prev >= node.val){
            return false;
        }
        prev = node.val;
        
        return inorder(node.right);
   }
}

// f(4)
//     f(2) -> T
//         f(1) -> T, prev=1
//         prev=2
//         f(6) -> T, prev=6
//     break here because prev,6 > 4
        
// TC: O(N)
// SC: O(N): the recursive stack's space