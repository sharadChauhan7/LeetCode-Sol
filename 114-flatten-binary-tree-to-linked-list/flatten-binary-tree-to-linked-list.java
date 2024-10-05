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
    static TreeNode temp =new TreeNode(-1);
    public void flatten(TreeNode root) {
        // if(root == null){
        //     return;
        // }
        // flatten(root.left);
        // flatten(root.right);
        // return;
        helper(root);
        return;
        // return;
    }
    public static TreeNode helper(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode lTail=helper(root.left);
        TreeNode rTail=helper(root.right);
        if(lTail!=null){
            lTail.right=root.right;
            root.right = root.left;
            root.left=null;
        }
        if(rTail!=null)return rTail;
        else if(lTail!=null)return lTail;
        return root;
    }
}