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
        ListNode head = null;
        ListNode tail = null;
        List<ListNode> nodes = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            nodes.add(lists[i]);
        }

        while(true){
            ListNode min = null;
            for(ListNode n: nodes){
                if(n!= null){
                    if(min == null || min.val > n.val){
                        min = n;
                    }
                }
            }
            if(min == null){
                break;
            }
            nodes.remove(min);
            ListNode node = new ListNode(min.val);
            if(head == null && tail == null){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
            if(min.next!=null){
                nodes.add(min.next);
            }
        }
        return head;
    }
}

//https://leetcode.com/problems/merge-k-sorted-lists/