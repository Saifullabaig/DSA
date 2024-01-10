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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            if(fast.next != null){
                if(fast.next.next != null){
                    fast = fast.next.next;
                }else{
                    return slow.next;
                }
            }else{
                return slow;
            }
            slow =slow.next;
        }
        return slow;
    }
}
//https://leetcode.com/problems/middle-of-the-linked-list/