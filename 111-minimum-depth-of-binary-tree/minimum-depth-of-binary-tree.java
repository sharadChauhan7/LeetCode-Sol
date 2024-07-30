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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int l = -1,r=-1;
        if(root.right != null){
            r=minDepth(root.right);
        }
        if(root.left!=null){
           l= minDepth(root.left);
        }
        if(l!=-1 && r!=-1){
            return Math.min(l,r)+1;
        }
        return Math.max(l,r)+1;
    }
}