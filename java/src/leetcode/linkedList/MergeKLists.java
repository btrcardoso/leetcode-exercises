package leetcode.linkedList;

//https://neetcode.io/problems/merge-k-sorted-linked-lists/question

import java.util.Comparator;
import java.util.PriorityQueue;

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

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(0);

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode cur = dummy;

        while (minHeap.size() > 0) {

            ListNode node = minHeap.poll();

            if (node.next != null) {
                minHeap.offer(node.next);
            }

            node.next = null;
            cur.next = node;
            cur = cur.next;

        }

        return dummy.next;

    }
}
