package leetcode.linkedList;

public class MergeKLists_merge {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) return null;
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = (start + end + 1) / 2;
        ListNode left = divide(lists, start, mid - 1);
        ListNode right = divide(lists, mid, end);

        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;

            } else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;

        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}