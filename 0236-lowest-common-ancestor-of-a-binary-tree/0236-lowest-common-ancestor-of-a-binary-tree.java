/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// suppose there is a method to let us know if the target node is on which side
// find(root.left, p)
// find(root.left, q)
class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return ans;
    }
    public boolean find(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return false;
        }
        
        boolean left = find(root.left, p, q);
        boolean right = find(root.right, p, q);
        boolean mid = false;
        if(p.val == root.val || q.val == root.val){
            mid = true;
        }
        if(left){
            if(right || mid){
                ans = root;    
            }
        }else{
            if(right && mid){
                ans = root;    
            }
        }
        return left || right || mid;
    }
}