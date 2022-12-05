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
    int K;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        helper(root);
        return ans;
    }
    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        K--;
        if(K==0){
            ans = root.val;
            return;
        }
        helper(root.right);
    }
}

// h(3)
//     h(1)
// h(5)
//     h(3)
//         h(2)
//             h(1)
//                 h(null)
//                 k=3->2
//                 h(null)
//             k=2->1
//             h(null)
//         k=1->0 , return 3