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
        int diaSum;
        int hsum;
        Info(int diaSum,int hsum){
            this.diaSum = diaSum;
            this.hsum = hsum;
        }
    }
    public int maxPathSum(TreeNode root) {
        int[] maxi = {Integer.MIN_VALUE};
         helper(root,maxi);
        return maxi[0];
    }

    public int helper(TreeNode root,int[] maxi){
        if(root == null){
            return 0;
        }
        int left = Math.max(0,helper(root.left,maxi));
        int right = Math.max(0,helper(root.right,maxi));
        maxi[0]= Math.max(left+right+root.val,maxi[0]);
       return Math.max(left,right)+root.val;
    }
}