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
        static int idx = 0;
    public void recoverTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        Collections.sort(ans);
        System.out.println(ans.get(1));
        idx=0;
        convertBST(root,ans);
    }
    public static void inOrder(TreeNode root,List<Integer> ans ){
        if(root==null){
            return;
        }
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
        return;
    }
    public static void convertBST(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        convertBST(root.left,ans);
        root.val = ans.get(idx++);
        convertBST(root.right,ans);
        return;
    }

}