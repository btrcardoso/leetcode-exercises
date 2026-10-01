import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// TODO: não resolvida

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }

    public List<Tree> getChildren() {
        return children;
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}


class SumInLeavesVisitor extends TreeVis {
    
    public int sum = 0;
    
    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {}

    public void visitLeaf(TreeLeaf leaf) {
      	this.sum += leaf.getValue();
    }
}

    class ProductOfRedNodesVisitor extends TreeVis {
    
    int product = 1;
    
    public int getResult() {
      	return product;
    }

    public void visitNode(TreeNode node) {
      	if (node.getColor() == Color.RED) {
            int val = node.getValue() == 0 ? 1 : node.getValue();
            product *= val;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
      	if (leaf.getColor() == Color.RED) {
            int val = leaf.getValue() == 0 ? 1 : leaf.getValue();
            product *= val;
        }
    }
}

class FancyVisitor extends TreeVis {
    
    int greenLeavesSum = 0;
    int nodesSum = 0;
    
    public int getResult() {
        return Math.abs(greenLeavesSum - nodesSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nodesSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if (leaf.getColor() == Color.GREEN) {
            greenLeavesSum += leaf.getValue();
        }
    }
}
public class JavaVisitorPattern {
    
    public static void print (Tree t, int depth) {

        String separator = "  ".repeat(depth);
        String nodeToPrint = "(" + t.getValue() + "," + t.getDepth() + ")";
        
        if (t instanceof TreeNode) {
            System.out.println(separator + "<" + nodeToPrint);

            TreeNode tn = (TreeNode) t;
            if (tn.getChildren().size() > 0) {
                for (Tree child : tn.getChildren()) {
                    print(child, depth + 1);
                }
            }

            System.out.println(separator + ">");
        } else {       
            System.out.println(separator + "<" + nodeToPrint + ">");
        }
        
    }

    private static Map<Integer, List<Integer>> map = new HashMap<>();
    private static int[] values;
    private static Color[] colors;

  
    public static Tree solve() {
        
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        values = new int[n];
        colors = new Color[n];
        
        for (int i = 0; i < n; i++) {
            values[i] = s.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            int color = s.nextInt();
            colors[i] = color == 0 ? Color.RED : Color.GREEN;
        }
        
        for (int i=0; i<n-1; i++) {
            int u = s.nextInt() - 1;
            int v = s.nextInt() - 1;
            
            List<Integer> uList = map.get(u) == null ? new ArrayList<>() : map.get(u);
            uList.add(v);
            map.put(u, uList);

            List<Integer> vList = map.get(v) == null ? new ArrayList<>() : map.get(v);
            vList.add(u);
            map.put(v, vList);
        }
        
        return buildTree(0, 0, -1);
    }

    public static Tree buildTree(int current, int depth, int parent) {

        // save node somewhere to return them here if they already exists

        List<Integer> children = map.get(current);
        TreeNode currentNode = new TreeNode(values[current], colors[current], depth);
        boolean hasChildren = false;

        for (Integer child : children) {
            if (child != parent) {
                Tree treeChild = buildTree(child, depth + 1, current);
                currentNode.addChild(treeChild);
                hasChildren = true;
            }
        }

        // see it again because some leves can have 2 parents

        return hasChildren ? currentNode : new TreeLeaf(values[current], colors[current], depth) ;
    }


    public static void main(String[] args) {
      	Tree root = solve();
        /*
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
        */
	}
}
