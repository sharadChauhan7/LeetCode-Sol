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
    public static void inOrder(TreeNode root,List<Integer> ans){
        if(root == null){
            return;
        }
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
        return;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        inOrder(root1,arr1);
        inOrder(root2,arr2);
        
        if(root1==null){
            return arr2;
        }
        if(root2==null){
            return arr1;
        }
        int i=0,j=0;

        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                ans.add(arr1.get(i++));
            }
            else{
                ans.add(arr2.get(j++));
            }
        }
        while(i<arr1.size()){
            ans.add(arr1.get(i++));
        }
        while(j<arr2.size()){
            ans.add(arr2.get(j++));
        }
        return ans;
    }
}