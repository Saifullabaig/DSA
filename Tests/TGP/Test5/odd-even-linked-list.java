/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

*/

class Solution {
    public Node oddEvenList(Node head) {
      if (head == null || head.next == null) {
          return head;
      }

      Node oddHead = new Node(0);
      Node evenHead = new Node(0);
      Node evenTail = evenHead;
      Node oddTail = oddHead;

      Node current = head;
      boolean isOdd = true;
      while(current!=null){
        if(isOdd){
          oddTail.next = current;
          oddTail = oddTail.next;
        }else{
          evenTail.next = current;
          evenTail = evenTail.next;
        }

        isOdd = !isOdd;
        current = current.next;
      }
      oddTail.next = evenHead.next;
      evenTail.next = null;
      return oddHead.next;
    }
}
