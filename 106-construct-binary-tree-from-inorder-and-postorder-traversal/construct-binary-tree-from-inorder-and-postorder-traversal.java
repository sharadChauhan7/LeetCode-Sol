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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
    }
    public TreeNode helper(int[] postorder,int preStart, int preEnd, int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> map){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[preEnd]);
        int inRoot = map.get(root.val);
        int nums = inRoot - inStart;

        root.right = helper(postorder, preStart+nums,preEnd-1,inorder,inRoot+1,inEnd,map);
        root.left = helper(postorder, preStart,preStart+nums-1,inorder,inStart,inRoot-1,map);
        return root;
    }
}