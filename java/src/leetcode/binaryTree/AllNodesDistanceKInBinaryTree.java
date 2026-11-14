package leetcode.binaryTree;

import java.util.*;

// Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/?envType=problem-list-v2&envId=7p5x763&sorting=W3sic29ydE9yZGVyIjoiREVTQ0VORElORyIsIm9yZGVyQnkiOiJGUkVRVUVOQ1kifV0%3D&page=1

class AllNodesDistanceKInBinaryTree {

    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node.left != null) {
                this.parent.put(node.left, node);
                queue.add(node.left);
            }

            if (node.right != null) {
                this.parent.put(node.right, node);
                queue.add(node.right);
            }

        }

        return nodesKDistant(target, k, new ArrayList<>());

    }

    public List<Integer> nodesKDistant(TreeNode node, int k, List<Integer> list) {
        childrenKDistant(node, k, list); // fill the list with the children that has k distance

        if (k > 0) {
            visited.add(node);                            // exclude the current from the search
            nodesKDistant(parent.get(node), k-1, list);   // fill the list with parent neighbors with k-1 distance
        }

        return list;
    }

    public void childrenKDistant(TreeNode node, int k, List<Integer> list) {
        if (node == null) {
            return;
        }
        
        if (k == 0) {
            list.add(node.val);
            return;
        } 

        if (node.left != null && !visited.contains(node.left)) {
            childrenKDistant(node.left, k-1, list);
        }

        if (node.right != null && !visited.contains(node.right)) {
            childrenKDistant(node.right, k-1, list);
        }
    }


}







/*



        3
    5        1
6     2    0    8
    7   4
   9     10

target = 2
k = 2


Map<Node, Node> parentMap = new HashMap<>();
Set<Node> visited = new HashSet<>();


target

    findChildrenInKDistance

    findParentInKDistance(parent, k-1)




*/