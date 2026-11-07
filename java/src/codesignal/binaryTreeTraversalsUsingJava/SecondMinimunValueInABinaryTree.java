package codesignal.binaryTreeTraversalsUsingJava;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SecondMinimunValueInABinaryTree {
    
    public static Integer second_minimum_in_tree(TreeNode root) {
        
        Integer[] min = new Integer[]{Integer.MAX_VALUE, null};
        
        dfs(root, min);
    
        return min[1] == Integer.MAX_VALUE ? null : min[1];
    }
    
    private static void dfs(TreeNode node, Integer[] min) {
        
        if (node == null) return;
        
        dfs(node.left, min);
        dfs(node.right, min);
        
        if (node.val < min[0]) {
            
            Integer temp = min[0];
            min[0] = node.val;
            min[1] = temp;
            
        } else if (min[1] != null && node.val < min[1] && node.val != min[0]) {
            
            min[1] = node.val;
            
        }
       
    }
}

/*

1 2 3 4 



*/