import java.util.LinkedList;
import java.util.Queue;



public class TreeNode {
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
 

// https://neetcode.io/problems/same-binary-tree/question

class SameBinaryTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        if (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)) {
            return false;
        }

        return true;
        
    }


    public boolean isSameTree_bfs(TreeNode p, TreeNode q) {

        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(p);

        Queue<TreeNode> qq = new LinkedList<>();
        qq.add(q);

        while (pq.size() > 0) {

            TreeNode pNode = pq.poll();
            TreeNode qNode = qq.poll();

            if (pNode == null && qNode == null) {
                continue;
            }

            if (pNode == null || qNode == null || pNode.val != qNode.val) {
                return false;
            }
            
            pq.add(pNode.left);
            pq.add(pNode.right);
            qq.add(qNode.left);
            qq.add(qNode.right);            

        }

        return pq.size() == qq.size();
        
    }
}


/*

BFS
2 stacks.
Time: O(n)
Space: O(n)



recursion? verify if the current root, left and right are the same. (no additional space?)
Time: O(n)
Space: O(n) not sure



*/



