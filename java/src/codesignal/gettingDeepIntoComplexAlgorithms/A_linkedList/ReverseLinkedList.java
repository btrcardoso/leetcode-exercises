package codesignal.gettingDeepIntoComplexAlgorithms.A_linkedList;

public class ReverseLinkedList {

    class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public static ListNode reverseLinkedList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while(current != null) {

            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;

        }

        return prev;

    }
}
    
}
