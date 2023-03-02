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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<Pair<Integer, TreeNode>> q =  new LinkedList<>();
        q.add(new Pair<>(0, root));
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.putIfAbsent(0, new ArrayList<>());
        map.get(0).add(root.val);
                    
        int min = 0;
        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                Pair<Integer, TreeNode> curr = q.poll();
                int idx = curr.getKey();
                TreeNode node= curr.getValue();
                if(node.left!=null){
                    map.putIfAbsent(idx-1, new ArrayList<>());
                    map.get(idx-1).add(node.left.val);
                    min = Math.min(min, idx-1);
                    q.add(new Pair<>(idx-1, node.left));
                }
                if(node.right!=null){
                    map.putIfAbsent(idx+1, new ArrayList<>());
                    map.get(idx+1).add(node.right.val);
                    max = Math.max(max, idx+1);
                    q.add(new Pair<>(idx+1, node.right));
                }
            }
        }
        for(int i=min; i<= max; i++){
            if(map.containsKey(i)){
                ans.add(new ArrayList<>(map.get(i)));
            }
        }
        return ans;
    }
}