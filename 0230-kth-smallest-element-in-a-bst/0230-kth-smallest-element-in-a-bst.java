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

// inorder traverse the tree: O(N)
class Solution {

    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        int count = 0;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            count++;
            if(count == k){
                return curr.val; 
            }            
            curr = curr.right;
        }
        
        return 0;
    }

}