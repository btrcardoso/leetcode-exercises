package codesignal.binaryTreeTraversalsUsingJava;

public class IsBinarySearchTree {
    public static boolean isBinarySearchTree(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static boolean isBST(TreeNode node, int min, int max) {
        
        if (node == null) {
            return true;
        }
        
        if (node.val < min || max < node.val) {
            return false;
        }
        
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }
}
