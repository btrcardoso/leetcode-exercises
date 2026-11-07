package codesignal.gettingDeepIntoComplexAlgorithms.A_linkedList;

/*


Your task is to write a function, removeDuplicates(ListNode head). This function takes the head of a linked list as a parameter. The function should remove all duplicate nodes from an unsorted linked list and return the head of the updated linked list. The order of the remaining nodes in the list should be the same as in the original.

In other words, if a linked list has duplicate values, all occurrences of such values, except for their first occurrence, must be deleted from the list. For instance, for the given linked list 1 -> 3 -> 2 -> 3 -> 2 -> 3 -> 4 -> 5 -> 5 -> 5 you should return 1 -> 3 -> 2 -> 4 -> 5.

*/

import java.util.*;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class RemoveDuplicates {
    
    public static ListNode removeDuplicates(ListNode head) {
        
        Set<Integer> set = new HashSet<>();
        
        ListNode prev = null;
        ListNode cur = head;
        
        while (cur != null) {
            
            if (!set.add(cur.value)) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            
            cur = cur.next;
            
        }        
        
        return head;
    }
}