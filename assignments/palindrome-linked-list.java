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
    public boolean isPalindrome(ListNode head) {
        ListNode fast, slow;
        slow = fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode firstHalfEnd = slow;
        ListNode secondHalfStart = reverse(slow.next);

        ListNode p1, p2;
        p1 = head;
        p2 = secondHalfStart;
        boolean res = true;
        while(p2 != null){
            if(p1.val != p2.val){
                res = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverse(secondHalfStart);
        return res;
    }

    private ListNode reverse(ListNode head){
        ListNode prev, curr, next;
        prev = null;
        curr = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

//https://leetcode.com/problems/palindrome-linked-list/