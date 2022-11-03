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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        TreeNode root = new TreeNode(preorder[0]);
        int N = preorder.length;
        int idx = 1;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);
        while((curr!=null || !stack.isEmpty()) && idx < N){
            if(preorder[idx] < curr.val){
                curr.left = new TreeNode(preorder[idx++]);
                stack.push(curr.left);
                curr = curr.left;
            }else{
                while(!stack.isEmpty() && stack.peek().val < preorder[idx]){
                    curr = stack.pop();
                }
                curr.right = new TreeNode(preorder[idx++]);
                stack.push(curr.right);
                curr = curr.right;
            }
        }
        return root;
    }
}