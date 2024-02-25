/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node iter = head;
        Node front = head;
        // step1: create copies
        while(iter != null){
            front = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }

        // step2: create random pointers
        iter = head;
        while(iter != null){
            if(iter.random != null){
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        } 

        // step3: separate copy and original
        iter = head;
        Node copy = new Node(0);
        Node pseudoHead = copy;
        while(iter!=null){
            front = iter.next.next;

            copy.next = iter.next;
            copy = copy.next;

            iter.next = front;
            iter = front;
        }
        return pseudoHead.next;
    }
}
//https://leetcode.com/problems/copy-list-with-random-pointer/