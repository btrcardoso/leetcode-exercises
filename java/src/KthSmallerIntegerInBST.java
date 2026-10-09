import java.util.*;

public class KthSmallerIntegerInBST {
    
    private void dfs(TreeNode root, List<Integer> elements) {

        if (root == null) {
            return;
        }

        dfs(root.left, elements);

        elements.add(root.val);

        dfs(root.right, elements);

    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> elements = new ArrayList<>();
        dfs(root, elements);
        return elements.get(k-1);
    }
}