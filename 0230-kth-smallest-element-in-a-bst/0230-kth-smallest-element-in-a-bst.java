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
// create a min heap to add the BST's nodes' values: SC: O(N)
// traverse the tree: O(N)
class Solution {
    int currIdx;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        currIdx = 0;
        ans =0;
        inorderTraverse(root, k);
        return ans;
    }
    
    public void inorderTraverse(TreeNode node, int k) {
        if(node==null){
            
            return;
        }
        // if(currIdx==k){
        //     ans = node.val;
        //     return ;
        // }
        inorderTraverse(node.left, k);
        currIdx++;
        if(currIdx==k){
            ans = node.val;
            return ;
        }        
        inorderTraverse(node.right, k);
    }
}