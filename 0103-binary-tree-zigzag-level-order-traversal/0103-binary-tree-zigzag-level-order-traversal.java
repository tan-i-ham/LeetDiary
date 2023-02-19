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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isEvenLevel = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> currList = new ArrayList<>();
            for(int i=0; i< size; i++){
                TreeNode curr = q.poll();
                currList.add(curr.val);
                
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            if(isEvenLevel){
                isEvenLevel = false;
            }else{
                // reverse
                Collections.reverse(currList);
                isEvenLevel = true;
            }
            ans.add(new ArrayList<>(currList));   
        }
        return ans;
    }
}