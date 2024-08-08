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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(root,targetSum,ans,curr);
        return ans;
    }

    public void helper(TreeNode root, int targetSum,List<List<Integer>> ans,List<Integer> curr){
        if(root == null){
            return;
        }
        curr.add(root.val);
        if(root.left == null && root.right ==null){
            if(targetSum-root.val==0){
                ans.add(new ArrayList(curr));
                curr.remove(curr.size()-1);
                return;
            }
        }
        helper(root.left,targetSum-root.val,ans,curr);
        helper(root.right,targetSum-root.val,ans,curr);
        curr.remove(curr.size()-1);
        return;
    }
}