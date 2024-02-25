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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.val - o2.val;
        });
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.offer(lists[i]);
            }
        }

        while(pq.size()>0){
            ListNode min = pq.poll();
            tail.next = min;
            tail = tail.next; 
            if(min.next!=null){
                pq.offer(min.next);
            }
        }
        return head.next;
    }
}
//https://leetcode.com/problems/merge-k-sorted-lists/