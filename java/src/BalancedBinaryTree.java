import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class BalancedBinaryTree {

    // iterative
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        Map<TreeNode, Integer> height = new HashMap<>();
        Stack<TreeNode> toVisit = new Stack<>();

        TreeNode node = root;
        TreeNode last = null; // last node processed


        while (node != null || toVisit.size() > 0) {

            if (node != null) {
                toVisit.add(node);    // root to visit later
                node = node.left;

            } else {
                node = toVisit.peek(); // get peek here to see if needs to calculate right node

                boolean needToCalcRightNode = node.right != null && last != node.right;
                if (needToCalcRightNode) {
                    node = node.right;

                } else {
                    // both children have been processed, then we can pop the peek and calculate its height
                    toVisit.pop();

                    // calculate 
                    int left = height.getOrDefault(node.left, 0);
                    int right = height.getOrDefault(node.right, 0);
                    if (Math.abs(left - right) > 1) return false;

                    // add current node height in the map
                    height.put(node, Math.max(left, right) + 1);

                    last = node; // to check in the next iteration, if this was the right node 
                    node = null; // in the next iteration, peek will be its father
                }

            }

            

        }

        return true;

    }


    /** Iterative

    Stack<TreeNode> stack = new Stack<>();
    Map<TreeNode, Integer> depths = new HashMap<>();

    TreeNode node = root;

    while (stack.size() > 0 || node != null) {
    
        if (node != null) {
            stack.add(node);  // add root in stack to see later
            node = node.left;
        } else {
            node = stack.peek();

            

        }
    
    }


    */










    // -------------------


    public int calculateHeight(TreeNode root, boolean[] balanced) {
        if (root == null) {
            return 0;
        }

        int left = calculateHeight(root.left, balanced);
        int right = calculateHeight(root.right, balanced);

        if (Math.abs(left - right) > 1) {
            balanced[0] = false;
        }

        return Math.max(left, right) + 1;

    }

    public boolean isBalanced_dfs(TreeNode root) {
        boolean[] balanced = new boolean[1];    // save the pointer. It could be a global variable too
        balanced[0] = true;
        calculateHeight(root, balanced);
        return balanced[0];
    }
}


/*


Math.abs(hLeft - hRight) > 1
    return false


if (root == null) {
    return true;
}




*/