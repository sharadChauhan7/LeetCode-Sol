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
    public class Info{
        int sum;
        int len;
        Info(int sum ,int len){
            this.sum=sum;
            this.len=len;
        }
    }
    static int count =0;
    public int averageOfSubtree(TreeNode root) {
        count =0;
        helper(root);
        return count;
    }
    public Info helper(TreeNode root){
        if(root == null){
            return new Info(0,0);
        }
        Info left = helper(root.left);
        Info right = helper(root.right);
        if((left.sum+right.sum+root.val)/(left.len+right.len+1)==root.val)count++;

        return new Info(left.sum+right.sum+root.val,left.len+right.len+1);
    }
}