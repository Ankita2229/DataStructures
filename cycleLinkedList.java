// Detect a cycle in the linked list
// Approach 1 - Mark the nodes as we visit. If we come across the same node again - Cycle exists! BUT - this will work only if we can modify the linked list.
// Approach 2 - Take 2 pointers. One goes with double speed as compared to other. If they collide before reaching the end point - cycle exists!

class Node{

  int data;
  Node next;
  
  boolean hasCycle(Node head){
    if(head == null) return false;
    
    Node fast = head.next;
    Node slow = head;
    
    while(fast != null && fast.next != null && slow != null){
      if(fast == slow) return true;
      fast = fast.next.next;
      slow = slow.next;
    }
    
    return false;
  }
}
