public class ValidateBinarySearchTree {

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


    public class Result {
        boolean isValid;
        TreeNode smallest;
        TreeNode biggest;

        Result(boolean isValid, TreeNode smallest, TreeNode biggest) {
            this.isValid = isValid;
            this.smallest = smallest;
            this.biggest = biggest;
        }

        Result(boolean isValid) {
            this.isValid = isValid;
        }
    }


    public Result isValidBSTResult(TreeNode root) {

        if (root.left == null && root.right == null) {
            return new Result(true);
        }

        if (root.left != null && root.left.val >= root.val) {
            return new Result(false);
        }

        if (root.right != null && root.right.val <= root.val) {
            return new Result(false);
        }

        TreeNode smallestChild = null;
        TreeNode biggestChild = null;

        if (root.left != null) {
            Result leftRes = isValidBSTResult(root.left);

            if (!leftRes.isValid) return new Result(false);

            if (leftRes.biggest != null && leftRes.biggest.val >= root.val) {
                return new Result(false);
            }

            if (leftRes.smallest == null) {
                smallestChild = root.left;
            } else {
                smallestChild = root.left.val < leftRes.smallest.val ? root.left : leftRes.smallest;
            }
        }

        if (root.right != null) {
            Result rightRes = isValidBSTResult(root.right);

            if (!rightRes.isValid) return new Result(false);

            if (rightRes.smallest != null && rightRes.smallest.val <= root.val) {
                return new Result(false);
            }

            if (rightRes.biggest == null) {
                biggestChild = root.right;
            } else {
                biggestChild = root.right.val > rightRes.biggest.val ? root.right : rightRes.biggest;
            }
        }

        return new Result(true, smallestChild, biggestChild);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTResult(root).isValid;
    }
}


/**
 * FIRST SOLUTION
 */


///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode() {}
// *     TreeNode(int val) { this.val = val; }
// *     TreeNode(int val, TreeNode left, TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
// */
//
//public class Result {
//    public List<TreeNode> children;
//    public boolean isValid;
//
//    public Result(List<TreeNode> children, boolean isValid) {
//        this.children = children;
//        this.isValid = isValid;
//    }
//}
//
//
//class Solution {
//
//    public Result trueIsValidBST(TreeNode root) {
//
//        List<TreeNode> children = new ArrayList<>();
//
//        if (root == null) {
//            return new Result(children ,true);
//        }
//
//        if (root.left == null && root.right == null) {
//            return new Result(children ,true);
//        }
//
//        if (root.left != null && root.left.val >= root.val) {
//            return new Result(null, false);
//        }
//
//        if (root.right != null && root.right.val <= root.val) {
//            return new Result(null, false);
//        }
//
//        Result leftResult = trueIsValidBST(root.left);
//        if (!leftResult.isValid) {
//            return new Result(null, false);
//        }
//
//        Result rightResult = trueIsValidBST(root.right);
//        if (!rightResult.isValid) {
//            return new Result(null, false);
//        }
//
//        // see if the lists are valid
//        for (TreeNode element : leftResult.children) {
//            if(element.val >= root.val) {
//                return new Result(null, false);
//            }
//        }
//
//        for (TreeNode element : rightResult.children) {
//            if(element.val <= root.val) {
//                return new Result(null, false);
//            }
//        }
//
//        leftResult.children.addAll(rightResult.children);
//        children = leftResult.children;
//
//        if(root.left != null) children.add(root.left);
//        if(root.right != null) children.add(root.right);
//
//        return new Result(children, true);
//
//    }
//
//    public boolean isValidBST(TreeNode root) {
//
//        TreeNode tree = new TreeNode( 1,
//                new TreeNode(4),
//                new TreeNode(6,
//                        new TreeNode(3),
//                        new TreeNode(7)
//                ));
//
//        return trueIsValidBST(root).isValid;
//
//    }
//}
