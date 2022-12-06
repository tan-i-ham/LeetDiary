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
// leverl order, by queue
// put the last element of every level to answer list
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); // [1]
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                TreeNode curr = q.poll(); // [] -> [2,3] -> [3] -> [5]
                if(i==size-1){
                    ans.add(curr.val); // [1] -> [1,3]
                }
                if(curr.left!=null){
                    q.offer(curr.left); // [2] -> 
                }
                if(curr.right!=null){
                    q.offer(curr.right); // [2,3] -> [3,5] -> [5,4]
                }
            }
        }
        return ans;
    }
}

// TC: O(N);
// SC: O(logN);