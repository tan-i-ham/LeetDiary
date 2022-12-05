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
// preorder: root, l, r, preorder find root
// inorder: l, root, r, inroder let you know what nodes are left or right
class Solution {
    int preorderIdx; // the idx in preorder array that help us identify the root val
    Map<Integer, Integer> inorderIdxMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // for quickly finding the tree, is constructed by the values from what range in inorder array
        inorderIdxMap = new HashMap<>(); 
        preorderIdx = 0; 
        int N = inorder.length;
        for(int i=0; i< N; i++){
            inorderIdxMap.put(inorder[i], i);
        }
        
        return build(preorder, inorder, 0, N-1);
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int l, int r) {
        if(l > r){
            return null;
        }
        int rVal = preorder[preorderIdx++];
        TreeNode root = new TreeNode(rVal);
        int splitIdx = inorderIdxMap.get(rVal);
    
        root.left = build(preorder, inorder, l, splitIdx- 1);
        root.right = build(preorder, inorder, splitIdx+ 1, r);
        return root;
    }
}