package codesignal.gettingDeepIntoComplexAlgorithms.A_linkedList;


class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        
        // find middle
        ListNode s = head, f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        
        // reverse starting in the middle
        ListNode prev = null;
        ListNode cur = s;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        // find palindrome
        ListNode left = head;
        ListNode right = prev;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        

        return true;
    }
}


/*


s
f 

     s
          f

          s
                    f                f.next == null
0    1    2    3    4                     
1 -> 2 -> 3 -> 4 -> 5

s
f 

     s
          f

          s
                    f                f = null 
0    1    2    3             
1 -> 2 -> 3 -> 4 



*/