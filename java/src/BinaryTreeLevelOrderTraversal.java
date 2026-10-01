import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



// https://leetcode.com/problems/binary-tree-level-order-traversal/?envType=problem-list-v2&envId=breadth-first-search
public class BinaryTreeLevelOrderTraversal {

    /**Definition for a binary tree node.public*/
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }}

        public List<List<Integer>> levelOrder(TreeNode root) {


        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        if (root != null) queue.add(root);

        while (queue.size() > 0) {

            int count = queue.size();

            List<Integer> level = new ArrayList<>();
            while (count > 0) {
                TreeNode cur = queue.poll();

                level.add(cur.val);

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);

                count --;
            }

            result.add(level);

        }

        return result;



    }
    
    public List<List<Integer>> levelOrder_2stacks(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        if (root != null) {
            queue.add(root);
            levels.add(0);
        }

        while (queue.size() > 0) {

            TreeNode cur = queue.poll();
            int l = levels.poll();

            List<Integer> nodesInLevel = l < result.size() ? result.get(l) : new ArrayList<>();
            nodesInLevel.add(cur.val);

            if (l < result.size()) {
                result.set(l, nodesInLevel);
            } else {
                result.add(nodesInLevel);
            }

            if (cur.left != null) {
                queue.add(cur.left);
                levels.add(l + 1);
            }

            if (cur.right != null) {
                queue.add(cur.right);
                levels.add(l + 1);
            }

        }

        return result;
        
    }

    public List<List<Integer>> levelOrder_old(TreeNode root) {

        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);

        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        levels.add(List.of(root.val));

        TreeNode currentNode;
        while (!queue.isEmpty()) {

            List<Integer> level = new ArrayList<Integer>();
            int queueSize = queue.size();

            for (int i = 0 ; i < queueSize; i ++){  // this is necessary to be sure we are only seeing the parents of the current level
                currentNode = queue.remove(0);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                    level.add(currentNode.left.val);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                    level.add(currentNode.right.val);
                }

            }

            if (!level.isEmpty()){
                levels.add(level);
            }

        }

        return levels;

    }

//    public <T> boolean isNotEmpty(List<T> list) {
//        return !list.isEmpty();
//    }
//
//    public boolean isValidNode(TreeNode treeNode) {
//        return treeNode != null;
//    }
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        if (root == null) {
//            return  new ArrayList<List<Integer>>();
//        }
//
//        List<List<Integer>> listOfLevels = new ArrayList<List<Integer>>();
//        List<Integer> level = new ArrayList<>(List.of(root.val)); // a level is a list of values
//        listOfLevels.add(level);
//
//        List<List<TreeNode>> queueOfGraphs = new ArrayList<List<TreeNode>>();
//        List<TreeNode> graph = new ArrayList<>(List.of(root)); // a graph is an amount of nodes which is in the same level
//        queueOfGraphs.add(graph);
//
//        List<TreeNode> currentGraph = null;
//        TreeNode currentNode = null;
//
//        while (isNotEmpty(queueOfGraphs)) {
//
//            currentGraph = queueOfGraphs.remove(0);
//            level = new ArrayList<Integer>();          // start to look at a new level
//            graph = new ArrayList<TreeNode>();         // start to build a new queue for the next level
//
//            while (isNotEmpty(currentGraph)) {
//
//                currentNode = currentGraph.remove(0);
//
//                if (isValidNode(currentNode.left)) {
//                    level.add(currentNode.left.val);
//                    graph.add(currentNode.left);
//                }
//
//                if (isValidNode(currentNode.right)) {
//                    level.add(currentNode.right.val);
//                    graph.add(currentNode.right);
//                }
//
//            }
//
//            if (isNotEmpty(level)) {
//                listOfLevels.add(level);
//                queueOfGraphs.add(graph);
//            }
//
//        }
//
//
//        return listOfLevels;
//    }
}
