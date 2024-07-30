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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int si,int ei){
        if(si>ei){
            return null;
        }
        int idx = findMax(nums,si,ei);
        TreeNode root = new TreeNode(nums[idx]);
        root.left = helper(nums,si,idx-1);
        root.right = helper(nums,idx+1,ei);
        return root;
    }
    public int findMax(int []nums, int si,int ei){
        int max= -1;
        int idx=-1;
        for(int i=si;i<=ei;i++){
            if(max<nums[i]){
                max= nums[i];
                idx=i;
            }
        }
        return idx;
    }
}