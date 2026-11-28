package leetcode.graph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class CloneGraph {
    public Node cloneGraph(Node root) {

        if (root == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(root);
        map.put(root, new Node(root.val));

        while (queue.size() > 0) {

            Node node = queue.poll();

            for (Node neighbor : node.neighbors) {

                Node neighborCopy = map.get(neighbor);

                if (neighborCopy == null) {
                    neighborCopy = new Node(neighbor.val);
                    map.put(neighbor, neighborCopy);
                    queue.offer(neighbor);
                }

                map.get(node).neighbors.add(neighborCopy);

            }

        }


        return map.get(root);
    }
}



