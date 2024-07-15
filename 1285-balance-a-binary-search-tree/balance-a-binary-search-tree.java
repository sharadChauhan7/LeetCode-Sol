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
    public void inOrder(TreeNode root,ArrayList<Integer>arr){
        if(root == null){
            return;
        }
        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right,arr);
        return;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> nums = new ArrayList<>();
        inOrder(root,nums);
        return helper(nums,0,nums.size()-1);
    }
    public TreeNode helper(ArrayList<Integer> nums,int si,int ei){

        if(si>ei){
            return null;
        }
        int mid = (si+ei)/2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left=helper(nums,si,mid-1);
        root.right=helper(nums,mid+1,ei);
        return root;
    }
}