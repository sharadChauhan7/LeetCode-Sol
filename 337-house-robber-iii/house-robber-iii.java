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
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> map= new HashMap<>();
        return robUtil(root,map);
    }
    public int robUtil(TreeNode curr,HashMap<TreeNode,Integer> map){
        if(curr == null){
            return 0;
        }
        int take = curr.val;
        if(map.containsKey(curr)){
            return map.get(curr);
        }
        if(curr.left!=null){
            take += robUtil(curr.left.left,map)+robUtil(curr.left.right,map);
        }
        if(curr.right!=null){
            take += robUtil(curr.right.left,map)+robUtil(curr.right.right,map);
        }

        int notTake =  robUtil(curr.left,map)+robUtil(curr.right,map);
        map.put(curr, Math.max(take,notTake));
        return Math.max(take,notTake);
    }
}