/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode one = headA,two=headB;

        while(one!=two){
            one=one.next;
            two=two.next;
            if(one==two){
                return one;
            }
            if(one==null) one=headB;
            if(two==null) two=headA;

        }
        return one;
    }
}