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
        while(prev!=null){
            if(!st.isEmpty()){
                if(prev.val>=st.peek().val){
                    st.push(prev);
                }
            }
            else{
                st.push(prev);
            }
            prev=prev.next;
        }
        if(!st.isEmpty()){
            head=st.pop();
        }
        curr=head;
        while(!st.isEmpty()){
            curr.next=st.pop();
            curr=curr.next;
        }
        curr.next=null;
        return head;
    }
}