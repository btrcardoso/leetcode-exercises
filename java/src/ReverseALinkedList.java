// https://neetcode.io/problems/reverse-a-linked-list/question
public class ReverseALinkedList {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    
    public ListNode reverseList(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode reversed = head;
        if (head.next != null){
            reversed = reverseList(head.next);   // head points to the last element of the reversedList (head.next)
            head.next.next = head;               // we make the last element points to the head
        }
        head.next = null;

        return reversed;
        
    }

    /*

   head               reversed
    1 -> 2 <- 3 <- 4 <- 5
         |
         v
        null 

    */


    // ------------------------------------------------------

    public ListNode reverse(ListNode node, ListNode previous) {

        if (node == null) {
            return previous;
        }

        ListNode temp = node.next;
        node.next = previous;

        return reverse(temp, node);

    }

    public ListNode reverseList_recursion1(ListNode head) {
        return reverse(head, null);   
    }

    // ------------------------------------------------------

    public ListNode reverseList_(ListNode head) {

        ListNode previous = null, node = head;

        while (node != null) {

            ListNode aux = node.next;
            node.next = previous;
            previous = node;
            node = aux;

        }

        return previous;
        
    }

/*

previous = null;
node = head;

aux = node.next

previous = node
node = aux

 o -> o -> o -> o -> null



*/
}



