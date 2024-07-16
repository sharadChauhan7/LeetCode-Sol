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
    private int i =0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        int ans = kthSmallest(root.left,k);
        if(ans == -1){
            i++;
            if(i==k){
                return root.val;
            }
        }
        else{
            return ans;
        }
        return kthSmallest(root.right,k);
    }
}