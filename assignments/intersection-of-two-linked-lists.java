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
        int l1 = 0, l2 = 0, diff = 0;
        ListNode list1 = headA, list2 = headB;
        while(list1 != null){
            list1 = list1.next;
            l1++;
        }
        while(list2 != null){
            list2 = list2.next;
            l2++;
        }
        if(l1<l2){
            list1 = headB;
            list2 = headA;
            diff = l2-l1;
        }else{
            list1 = headA;
            list2 = headB;
            diff = l1 -l2;
        }
        for(int i=0;i<diff;i++){
            list1=list1.next;
        }
        while(list1!=null && list2!=null){
            if(list1 == list2){
                return list1;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return null;
    }
}
//https://leetcode.com/problems/intersection-of-two-linked-lists/