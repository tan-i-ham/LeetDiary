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
// map: {parent: [l, r] }
// { 20: [15,17], 50: [20,80], 80: [19,] }
// stack=[20] -> [50]
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> childs = new HashSet<>();
        for(int[] description: descriptions){
            int nodeVal = description[0];
            int childVal = description[1];
            int pos = description[2];
            
            childs.add(childVal);
            
            TreeNode node = map.getOrDefault(nodeVal, new TreeNode(nodeVal));
            if(pos==1){
                node.left = map.getOrDefault(childVal, new TreeNode(childVal)); // left
                map.put(childVal, node.left);
            }else{
                node.right = map.getOrDefault(childVal, new TreeNode(childVal)); // right
                map.put(childVal, node.right);
            }
            map.put(nodeVal, node);
        }
        int root = -1;
        // find root
        for(int[] description: descriptions){
            int nodeVal = description[0];
            if(!childs.contains(nodeVal)){
                root = nodeVal;
                break;
            }
        }
   
        return map.get(root);
    }
}