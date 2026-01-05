// https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int base = 10;
        int carry = 0;
        ListNode firstNode = new ListNode();
        ListNode currentNode = firstNode;

        while (l1 != null || l2 != null || carry == 1) {

            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;

            int sum = a + b + carry;

            if (sum >= base) {
                currentNode.val = sum - base;
                carry = 1;
            } else {
                currentNode.val = sum;
                carry = 0;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            if (l1 != null || l2 != null || carry == 1) {
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
            }

        }

        return firstNode;

    }

    // System.out.println("---");
    // System.out.print("l1: ");
    // print(l1);
    // System.out.print("\nl2: ");
    // print(l2);
    // System.out.println("\ncarry: " + carry);

//    public static void print(ListNode l) {
//
//        if (l != null){
//            System.out.print(l.val);
//            if(l.next != null) {
//                System.out.print(" -> ");
//            }
//            print(l.next);
//        }
//    }
}
