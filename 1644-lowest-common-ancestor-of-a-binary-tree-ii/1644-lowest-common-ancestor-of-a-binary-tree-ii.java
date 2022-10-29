/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        
        Map<TreeNode, TreeNode> parentByChild = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty() && 
              ( !parentByChild.containsKey(p) || !parentByChild.containsKey(q) )
              ){
            TreeNode parent = stack.pop();
            
            if(parent.left!=null){
                parentByChild.put(parent.left, parent);
                stack.push(parent.left);
            }
            if(parent.right!=null){
                parentByChild.put(parent.right, parent);
                stack.push(parent.right);
            }
        }
        if(!parentByChild.containsKey(p) || !parentByChild.containsKey(q)){
           return null; 
        }
        
        List<TreeNode> parentsOfP = new ArrayList<>();
        while(p!=null){
            parentsOfP.add(p);
            p = parentByChild.get(p);
        }
        while(!parentsOfP.contains(q)){
            q = parentByChild.get(q);
        }
        return q;
    }
}