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
    class Info{
        int dia;
        int h;

        Info(int dia , int h){
            this.dia = dia;
            this.h = h;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Info ans = helper(root);
        return Math.max(ans.dia,ans.h)-1;
    }
    public Info helper(TreeNode root){
        if(root == null){
            return new Info(0,0);
        }
        Info left =helper(root.left);
        Info right = helper(root.right);

        int diam = Math.max(Math.max(left.dia,right.dia),left.h+right.h+1);
        int height = Math.max(left.h,right.h)+1;

        return new Info(diam,height);
    }
}