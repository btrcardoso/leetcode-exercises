import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/word-search/description/?envType=problem-list-v2&envId=depth-first-search

public class WordSearch {

    public int m;
    public int n;
    public char[][] board;

    public boolean dfs(int i, int j, String word) {

        if (!(-1 < i && i < this.m && -1 < j && j < this.n)) {
            return false;
        }

        if (this.board[i][j] == '0') {
            return false;
        }

        if (word.length() == 1) {
            return this.board[i][j] == word.charAt(0);
        }

        char currentChar = this.board[i][j];

        if (currentChar == word.charAt(0)) {

            this.board[i][j] = '0';

            int row = -1;
            int column = -1;
            boolean result = false;

            while (result == false) {

                if (row == -1 && column == -1) {
                    // right
                    row = i;
                    column = j + 1;

                } else if (row == i && column == j + 1) {
                    // bottom
                    row = i + 1;
                    column = j;

                } else if (row == i + 1 && column == j) {
                    // left
                    row = i;
                    column = j - 1;

                } else if (row == i && column == j - 1) {
                    // up
                    row = i - 1;
                    column = j;

                } else {
                    // backtracking
                    this.board[i][j] = currentChar;
                    return false;
                }

                result = dfs(row, column, word.substring(1));

                if (result == true) {
                    return true;
                }

            }

        }

        return false;

    }

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.m = this.board.length;
        this.n = this.m == 0 ? 0 : this.board[0].length;

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if ( dfs(i, j, word) ) {
                    return true;
                }
            }

        }

        return false;

    }

    // solution 2

//    class Node {
//        public int row;
//        public int column;
//        public Node lastVisited;
//
//        public Node (int r, int c) {
//            this.row = r;
//            this.column = c;
//        }
//    }
//
//    public boolean validPosition(Node node, char[][] board){
//        int i = node.row;
//        int j = node.column;
//
//        int m = board.length;
//        int n = m == 0 ? 0 : board[0].length;
//
//        return validPositionInt(i,j,m,n);
//    }
//
//    public boolean validPositionInt(int i, int j, int m, int n){
//        return (-1 < i) && (i < m) && (-1 < j) && (j < n);
//    }
//
//    public boolean alreadyOnStack(Node node, List<Node> stack) {
//        for (Node listNode : stack) {
//            if (node.row == listNode.row && node.column == listNode.column) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean dfs(Node root, char[][] board, String word, List<Node> stack) {
//
//        if (word.length() == 0) {
//            return true;
//        }
//
//        if (!validPosition(root, board) || alreadyOnStack(root, stack)) {
//            if(stack.size() > 0){
//                stack.remove(stack.size()-1);
//            }
//            return false;
//        }
//
//        if ( board[root.row][root.column] == word.charAt(0) ) {
//
//            do {
//
//                if (root.lastVisited == null) {
//                    root.lastVisited = new Node(root.row, root.column + 1);
//
//                } else if (root.lastVisited.row == root.row && root.lastVisited.column == root.column + 1) {
//                    root.lastVisited = new Node(root.row + 1, root.column);
//
//                } else if (root.lastVisited.row == root.row + 1 && root.lastVisited.column == root.column) {
//                    root.lastVisited = new Node(root.row, root.column - 1);
//
//                } else if (root.lastVisited.row == root.row && root.lastVisited.column == root.column - 1) {
//                    root.lastVisited = new Node(root.row - 1, root.column);
//
//                } else {
//                    if(stack.size() > 0){
//                        stack.remove(stack.size()-1);
//                    }
//                    return false;
//                }
//
//                stack.add(root);
//
//            } while (! dfs(root.lastVisited, board, word.substring(1), stack) );
//
//            return true;
//
//        } else {
//            if(stack.size() > 0){
//                stack.remove(stack.size()-1);
//            }
//            return false;
//        }
//
//    }
//
//    public boolean exist(char[][] board, String word) {
//        List<Node> stack = new ArrayList<>();
//        Node root = new Node(0,0);
//
//        while ( !dfs(root, board, word, stack) ) {
//
//            int m = board.length;
//            int n = m == 0 ? 0 : board[0].length;
//            int newRow = root.column == n-1 ? root.row + 1 : root.row;
//            int newColumn = (root.column + 1) % n;
//
//            root = new Node(newRow, newColumn);
//
//            if (!validPosition(root, board)) {
//                return false;
//            }
//
//        }
//
//        return true;
//    }

    // solution 1
//    class Node {
//        public int row;
//        public int column;
//        public int lastVisitedRow = -1;
//        public int lastVisitedColumn = -1;
//
//        public Node (int r, int c) {
//            // System.out.println("Nó criado: "+ r + ", " + c);
//            this.row = r;
//            this.column = c;
//        }
//    }
//
//    public boolean validPosition(int i, int j, int m, int n){
//        return (-1 < i) && (i < m) && (-1 < j) && (j < n);
//    }
//
//    public boolean alreadyOnStack(int i, int j, List<Node> stack) {
//        for (Node node : stack) {
//            if (node.row == i && node.column == j) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public Node goBack(Node current, List<Node> stack, int m, int n) {
//
//        if (!stack.isEmpty()) {
//            return stack.remove(stack.size() - 1);
//
//        } else {
//            int newRow = current.column == n-1 ? current.row + 1 : current.row;
//            int newColumn = (current.column + 1) % n;
//
//            if (!validPosition(newRow, newColumn, m, n)) {
//                return null;
//            }
//            return new Node(newRow, newColumn);
//
//        }
//    }
//
//    public boolean exist(char[][] board, String word) {
//
//        int m = board.length;
//        if (m == 0) {
//            return false;
//        }
//
//        int n = board[0].length;
//        if (n == 0) {
//            return false;
//        }
//
//        List<Node> stack = new ArrayList<>();
//        Node current = new Node(0,0);
//        int newRow, newColumn;
//        boolean addNew = true;
//
//        while (stack.size() < word.length()) {
//
//            if (board[current.row][current.column] == word.charAt(stack.size())) {
//
//                /* looking for the next node */
//                newRow = -1;
//                newColumn = -1;
//                while (!validPosition(newRow, newColumn, m, n) || alreadyOnStack(newRow, newColumn, stack)) {
//
//                    if(stack.size() + 1 == word.length()){
//                        return true;
//                    }
//
//                    if (current.lastVisitedRow == -1 && current.lastVisitedColumn == -1) {
//                        // right
//                        newRow = current.row;
//                        newColumn = current.column + 1;
//                    } else if (current.lastVisitedRow == current.row && current.lastVisitedColumn == current.column + 1) {
//                        // bottom
//                        newRow = current.row + 1;
//                        newColumn = current.column;
//                    } else if (current.lastVisitedRow == current.row + 1 && current.lastVisitedColumn == current.column) {
//                        // left
//                        newRow = current.row;
//                        newColumn = current.column - 1;
//                    } else if (current.lastVisitedRow == current.row && current.lastVisitedColumn == current.column - 1) {
//                        // up
//                        newRow = current.row - 1;
//                        newColumn = current.column;
//                    } else {
//                        // System.out.println("no more nodes left");
//                        current = goBack(current, stack, m, n);
//
//                        if (current == null) {
//                            return false;
//                        }
//
//                        addNew = false;
//                        break;
//                    }
//
//                    current.lastVisitedRow = newRow;
//                    current.lastVisitedColumn = newColumn;
//                }
//
//                if (addNew) {
//                    stack.add(current);
//                    current = new Node(newRow, newColumn);
//                } else {
//                    addNew = true;
//                }
//
//            } else {
//                current = goBack(current, stack, m, n);
//
//                if (current == null) {
//                    return false;
//                }
//            }
//
//        }
//
//        return true;
//    }
}