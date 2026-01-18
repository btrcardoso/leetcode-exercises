import java.util.ArrayList;
import java.util.List;

/*
 queue: 1,
 queue: 1x,
 child: 2, 3, queue: 1x, 2, 3

 queue: 2x, 3
 child: 4, 5, queue: 2x, 3, 4, 5
 queue: 2x, 3x, 4, 5
 child: 6, 7, queue: 2x, 3x, 4, 5, 6, 7

 queue: 4x, 5, 6, 7
 child: 8, 9, queue: 4x, 5, 6, 7, 8, 9
 queue: 4x, 5x, 6, 7, 8, 9
 child: 10, 11, queue: 4x, 5x, 6, 7, 8, 9, 10, 11
 ...
 ...
 ...
 ...

 ...

*/

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/?envType=problem-list-v2&envId=breadth-first-search
public class PopulatingNextRIghtPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {

        if(root == null) {
            return root;
        }

        List<Node> queue = new ArrayList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int sizeQueue = queue.size();

            for (int i = 0 ; i < sizeQueue ; i++) {
                Node currentNode = queue.remove(0);

                if (!queue.isEmpty()) {
                    Node next = queue.get(0);
                    if (i < sizeQueue - 1) {
                        currentNode.next = next;
                    }
                }

                if (currentNode.left != null && currentNode.right != null) {
                    queue.add(currentNode.left);
                    queue.add(currentNode.right);
                }

            }

        }

        return root;

    }
}
