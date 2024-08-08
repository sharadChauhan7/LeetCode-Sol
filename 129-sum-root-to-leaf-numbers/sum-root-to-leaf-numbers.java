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
    static int sum =0;
    public int sumNumbers(TreeNode root) {
        sum=0;
        helper(root,0);
        return sum;
    }
    public static void helper(TreeNode root , int n){
        if(root== null){
            return;
        }
        n= n*10+root.val;
        if(root.left== null && root.right == null){
            sum+=n;
            return;
        }
            helper(root.left,n);
            helper(root.right,n);
    }
}