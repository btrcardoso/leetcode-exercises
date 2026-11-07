package codesignal.gettingDeepIntoComplexAlgorithms.A_linkedList;

public class HasCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        
        while (f != null && f.next != null) {
            
            s = s.next;
            f = f.next.next;
            
            if (s == f) {
                return true;
            }
            
        }
        
        return false;
    }
}