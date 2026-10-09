public class MergeTwoSortedLinkedLists {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    } 

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            if (list1 == null) {
                return list2;
            }

            if (list2 == null) {
                return list1;
            }

            if( list1.val < list2.val ) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } 

            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
            
            
        }
        
        public ListNode mergeTwoLists_(ListNode list1, ListNode list2) {

            if (list1 == null) {
                return list2;
            }

            if (list2 == null) {
                return list1;
            }
            
            ListNode head, cur;

            // choose the first cur
            if (list1.val <= list2.val) {
                head = cur = list1;
                list1 = list1.next;
            } else {
                head = cur = list2;
                list2 = list2.next;
            }

            while (list1 != null || list2 != null) {

                while (list1 != null && (list2 == null || list1.val <= list2.val) ) {
                    cur.next = list1;
                    cur = cur.next;

                    list1 = list1.next;
                }

                while (list2 != null && (list1 == null || list2.val <= list1.val) ) {
                    cur.next = list2;
                    cur = cur.next;

                    list2 = list2.next;
                }

            }

            return head;
        }
    }
}



/*

        v
1->3->5

        v
1->2->4



1->1->2->3->4->5

*/























