package codesignal.gettingDeepIntoComplexAlgorithms.A_linkedList;


    


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val= val;
        this.next = null;
    }
}
public class RotateRightLinkedList {
    
    class ReverseInfo {
        ListNode head;
        ListNode cur;
        int count;
        
        ReverseInfo(ListNode head, ListNode cur, int count) {
            this.head = head;
            this.cur = cur;
            this.count = count;
        }
    }
    
    private ReverseInfo reverse(ListNode head, int k) {
        
        if (k == 0) {
            k = Integer.MAX_VALUE;
        }
        
        ListNode prev = null;
        ListNode cur = head;
        
        int count = 0;
        
        while (cur != null && count < k) {
            
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            
            count++;
        }
        
        return new ReverseInfo(prev, cur, count);
        
    }
    
    
    public ListNode rotateRight(ListNode head, int k) {
        
        ReverseInfo r1 = reverse(head, Integer.MAX_VALUE);
        
        k = k % r1.count;
        
        ReverseInfo r2 = reverse(r1.head, k);
        
        ReverseInfo r3 = reverse(r2.cur, Integer.MAX_VALUE);
        
        r1.head.next = r3.head;
        
        return r2.head;
        
    }
}


/*

1 -> 2 -> 3 -> 4 -> 5

1 <- 2 <- 3 <- 4 <- 5
                   r1.head

1 <- 2 <- 3    4 -> 5 ->
       r2.cur r2.head
         
1 -> 2 -> 3    4 -> 5 ->
r3.head      r2.head   
         

*/