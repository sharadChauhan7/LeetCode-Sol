/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p){
            return p;
        }
        if(root == q){
            return q;
        }
        TreeNode l;
        TreeNode r;
        if(p.val<root.val){
             l= lowestCommonAncestor(root.left,p,q);
        }
        else{
             l= lowestCommonAncestor(root.right,p,q);
        }
        if(q.val<root.val){
             r= lowestCommonAncestor(root.left,p,q);
        }
        else{
             r= lowestCommonAncestor(root.right,p,q);
        }

        if(l!=null && r !=null){
            if(l==r){
                return l;
            }
            return root;
        }

        if(l!=null && r ==null){
            return l;
        }
        if(l==null && r!=null){
            return r;
        }
        return null;

    }
}