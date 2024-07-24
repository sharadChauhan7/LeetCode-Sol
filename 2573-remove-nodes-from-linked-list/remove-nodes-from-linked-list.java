/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        if(head==null){
            return head;
        }
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // return prev;
        head = prev;
        curr=prev.next;
        while(curr!=null){
            if(curr.val<prev.val){
                curr=curr.next;
            }
            else{
                ListNode next = curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
        }
        head.next=null;
        return prev;

    }
}