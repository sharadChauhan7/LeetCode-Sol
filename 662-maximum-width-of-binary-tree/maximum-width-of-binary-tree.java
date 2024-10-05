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
    static class Info{
        int num;
        TreeNode n;
        
        public Info(int num,TreeNode n){
            this.num=num;
            this.n=n;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0,root));
        q.add(null);

        // int min=0,max=0;
        int ans =1,start=0;
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                start=q.peek().num;
                q.add(null);
            }
            else{
                ans = Math.max(ans,curr.num-start+1);
                if(curr.n.left!=null){
                    q.add(new Info(curr.num*2+1,curr.n.left));
                }
                if(curr.n.right!=null){
                    q.add(new Info(curr.num*2+2,curr.n.right));
                }
            }
        }
        
        return ans;
    }
}