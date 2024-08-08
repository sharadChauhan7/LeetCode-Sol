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
    int count =0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int c = CountPathSum(root,targetSum);
        int l = pathSum(root.left,targetSum);
        int r = pathSum(root.right,targetSum);
        return c+l+r;

    }
    public int CountPathSum(TreeNode root, long targetSum) {
        if(root == null){
            return 0;
        }
        int count =0;
        if(root.val - targetSum == 0){
            count++;
        }
        int l =  CountPathSum(root.left,targetSum-root.val) ;
        int r = CountPathSum(root.right,targetSum-root.val);
        return l+r+count;
    }
}