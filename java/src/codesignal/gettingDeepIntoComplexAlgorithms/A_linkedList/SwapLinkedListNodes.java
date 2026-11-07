package codesignal.gettingDeepIntoComplexAlgorithms.A_linkedList;

    
/*
You are given a singly linked list and two indices, start and end (both indices are 0-based). Write a Java function swapLinkedListNodes(ListNode head, int start, int end) that swaps the nodes of the linked list at these two provided indices. The function should return the head node of the modified linked list. When swapping, you should only change the next property of a node, not the actual node values. It is guaranteed that start <= end.

For example, consider the linked list 1 -> 2 -> 3 -> 4 -> 5 and you are given start = 1 and end = 3. The resulting linked list after swapping nodes at indices 1 and 3 would be:

text
Copy to clipboard
1 -> 4 -> 3 -> 2 -> 5
The expected time complexity of your solution should be 
O
(
n
)
O(n), where 
n
n is the length of the linked list.

*/


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SwapLinkedListNodes {
    public static ListNode swapLinkedListNodes(ListNode head, int start, int end) {
        ListNode dummy = new ListNode(0, head);

        int i = 0;
        
        ListNode prevStart = dummy;
        while (i < start) {
            prevStart = prevStart.next;
            i++;
        }
        
        ListNode prevEnd = prevStart;
        while (i < end) {
            prevEnd = prevEnd.next;
            i++;
        }
        
        ListNode nodeStart = prevStart.next;
        ListNode nodeEnd = prevEnd.next;

        // swap
        ListNode temp = nodeEnd.next;

        prevStart.next = nodeEnd;
        nodeEnd.next = nodeStart.next;

        prevEnd.next = nodeStart;
        nodeStart.next = temp;

        return dummy.next;
    }
}



/*

0    1    2    3    4
1 -> 2 -> 3 -> 4 -> 5

ListNode dummy = new ListNode(0, head);

prevStart = dummy
nodeStart = head
i == start 


prevEnd = prevStart
nodeEnd = nodeStart
i == end


ListNode temp = nodeEnd.next;

prevStart.next = nodeEnd;
nodeEnd.next = nodeStart.next;

prevEnd.next = nodeStart;
nodeStart.next = temp;




*/