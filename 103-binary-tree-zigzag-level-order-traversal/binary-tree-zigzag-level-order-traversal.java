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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> f = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return f;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean flag=true;
        
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr==null){
                f.add(ans);
                ans = new ArrayList<>();
                flag=!flag;
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
            }
            else{
                if(flag){
                    ans.add(curr.val);
                }
                else{
                    ans.add(0,curr.val);
                }
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
            }
        }  
        return f;
    }
}