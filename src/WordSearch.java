import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/word-search/description/?envType=problem-list-v2&envId=depth-first-search

public class WordSearch {

    class Node {
        public int row;
        public int column;
        public int lastVisitedRow = -1;
        public int lastVisitedColumn = -1;

        public Node (int r, int c) {
            // System.out.println("Nó criado: "+ r + ", " + c);
            this.row = r;
            this.column = c;
        }
    }

    public boolean validPosition(int i, int j, int m, int n){
        return (-1 < i) && (i < m) && (-1 < j) && (j < n);
    }

    public boolean alreadyOnStack(int i, int j, List<Node> stack) {
        for (Node node : stack) {
            if (node.row == i && node.column == j) {
                return true;
            }
        }
        return false;
    }

    public Node goBack(Node current, List<Node> stack, int m, int n) {

        if (!stack.isEmpty()) {
            return stack.remove(stack.size() - 1);

        } else {
            int newRow = current.column == n-1 ? current.row + 1 : current.row;
            int newColumn = (current.column + 1) % n;

            if (!validPosition(newRow, newColumn, m, n)) {
                return null;
            }
            return new Node(newRow, newColumn);

        }
    }

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        if (m == 0) {
            return false;
        }

        int n = board[0].length;
        if (n == 0) {
            return false;
        }

        List<Node> stack = new ArrayList<>();
        Node current = new Node(0,0);
        int newRow, newColumn;
        boolean addNew = true;

        while (stack.size() < word.length()) {

            if (board[current.row][current.column] == word.charAt(stack.size())) {

                /* looking for the next node */
                newRow = -1;
                newColumn = -1;
                while (!validPosition(newRow, newColumn, m, n) || alreadyOnStack(newRow, newColumn, stack)) {

                    if(stack.size() + 1 == word.length()){
                        return true;
                    }

                    if (current.lastVisitedRow == -1 && current.lastVisitedColumn == -1) {
                        // right
                        newRow = current.row;
                        newColumn = current.column + 1;
                    } else if (current.lastVisitedRow == current.row && current.lastVisitedColumn == current.column + 1) {
                        // bottom
                        newRow = current.row + 1;
                        newColumn = current.column;
                    } else if (current.lastVisitedRow == current.row + 1 && current.lastVisitedColumn == current.column) {
                        // left
                        newRow = current.row;
                        newColumn = current.column - 1;
                    } else if (current.lastVisitedRow == current.row && current.lastVisitedColumn == current.column - 1) {
                        // up
                        newRow = current.row - 1;
                        newColumn = current.column;
                    } else {
                        // System.out.println("no more nodes left");
                        current = goBack(current, stack, m, n);

                        if (current == null) {
                            return false;
                        }

                        addNew = false;
                        break;
                    }

                    current.lastVisitedRow = newRow;
                    current.lastVisitedColumn = newColumn;
                }

                if (addNew) {
                    stack.add(current);
                    current = new Node(newRow, newColumn);
                } else {
                    addNew = true;
                }

            } else {
                current = goBack(current, stack, m, n);

                if (current == null) {
                    return false;
                }
            }

        }

        return true;
    }
}