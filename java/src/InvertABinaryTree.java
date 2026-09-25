import java.util.LinkedList;
import java.util.Queue;

//https://neetcode.io/problems/invert-a-binary-tree/question

// Definition for a binary tree node.
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
    }
}

public class InvertABinaryTree {
    public TreeNode invertTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (queue.size() > 0) {

            TreeNode current = queue.poll();

            TreeNode aux = current.left;
            current.left = current.right;
            current.right = aux;

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }

        }

        return root;

    }


    // public TreeNode invertTree(TreeNode root) {

    //     if (root == null){
    //         return null;
    //     }

    //     TreeNode left = root.left;
    //     root.left = root.right;
    //     root.right = left;

    //     invertTree(root.left);
    //     invertTree(root.right);

    //     return root;

    // }
}
