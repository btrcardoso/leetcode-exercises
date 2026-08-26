import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    // Space: 3*n*n => O(n²)
    // Time: n*n => O(n²)
    public boolean isValidSudoku_onePass(char[][] board) {

        Map<Integer, Set<Character>> lines = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> boxes = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j<board[i].length; j++) {

                char curChar = board[i][j];
                if (curChar != '.') {

                    int boxLine = i/3;
                    int boxCol = j/3;
                    int boxId = boxLine*3 + boxCol;
                    Set<Character> boxSet = boxes.get(boxId) == null ? new HashSet<>() : boxes.get(boxId);
                    Set<Character> lineSet = lines.get(i) == null ? new HashSet<>() : lines.get(i);
                    Set<Character> colSet = columns.get(j) == null ? new HashSet<>() : columns.get(j);

                    if (!boxSet.add(curChar)) {
                        return false;
                    }

                    if (!lineSet.add(curChar)) {
                        return false;
                    }

                    if (!colSet.add(curChar)) {
                        return false;
                    }

                    boxes.put(boxId, boxSet);
                    lines.put(i, lineSet);
                    columns.put(j, colSet);

                }

            }
        }

        return true;
        
    }


/*

lines
0 -> 1,2,3
1 -> 4,5
.
.
.

columns
0 -> 1,4,5,7
1 -> 2,9
.
.
.

box
0 -> 1,2,4,9,8
1 -> 3,5
.
.
.




boxLine, boxCol -> boxId

0,0 -> 0
0,1 -> 1
0,2 -> 2

1,0 -> 3
1,1 -> 4
1,2 -> 5

2,0 -> 6
2,1 -> 7
2,2 -> 8

boxLine = i/3
boxCol = j/3
formula = boxLine*3 + boxCol


*/


// ------------------------------------------------------------------------------------------

    // Space: O(n)
    // Time: O(n²)
    public boolean isValidSudoku_bruteForce(char[][] board) {

        Set<Character> hashRow = new HashSet<>();
        Set<Character> hashCol = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.' && !hashRow.add(board[i][j]) ) {
                    return false;
                }

                if (board[j][i] != '.' && !hashCol.add(board[j][i]) ) {
                    return false;
                }

            }

            hashRow.clear();
            hashCol.clear();
        }

        Set<Character> hashBox = new HashSet<>();

        for(int k = 0; k < 3; k++) {

            for (int l = 0; l < 3; l++) {

                for (int i = k*3; i < (k+1)*3; i++) {

                    for (int j = l*3; j < (l+1)*3; j++) {

                        if (board[i][j] != '.' && !hashBox.add(board[i][j]) ) {
                            return false;
                        }

                    }

                }

                hashBox.clear();

            }

        }

        return true;
        
    }
    
}
