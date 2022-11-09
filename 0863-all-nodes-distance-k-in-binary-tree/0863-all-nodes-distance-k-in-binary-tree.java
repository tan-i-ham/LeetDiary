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
    Map<TreeNode, TreeNode> parByChild;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parByChild = new HashMap<>(); // key is child node, value is parent node
        
        buildMap(root, root);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        
        int dist = 0;
        while(!q.isEmpty() && dist < k){
            dist++;
            int size = q.size();
            for(int i=0; i< size; i++){
                TreeNode curr = q.poll();
                if(curr.left!= null && !seen.contains(curr.left) ){
                    seen.add(curr.left);
                    q.add(curr.left);
                }
                if(curr.right!= null && !seen.contains(curr.right) ){
                    seen.add(curr.right);
                    q.add(curr.right);
                }
                TreeNode par = parByChild.get(curr);
                if(!seen.contains(par) ){                
                    seen.add(par);
                    q.add(par);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
    
    public void buildMap(TreeNode node, TreeNode parent){
        if(node != null){
            if(parent!=null){
                parByChild.put(node, parent);    
            }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }
}