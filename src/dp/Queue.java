package dp;

/**
 * N皇后问题
 *
 * @Author: zouhongxue
 * @Date: 2019/4/28 3:32 PM
 */
public class Queue {

    public static void main(String[] args) {
        int n = 8;
        int[][] chessBoard = initChessBoard(n);
        putChess(chessBoard, 0);

        for (int[] aChessBoard : chessBoard) {
            for (int anAChessBoard : aChessBoard) {
                System.out.print(anAChessBoard + "\t");
            }
            System.out.println();
        }
    }

    private static boolean putChess(int[][] chessBoard, int rowNum) {
        if (rowNum == chessBoard.length) {
            return true;
        }
        for (int colNum = 0; colNum < chessBoard.length; colNum++) {
            //回溯清理
            for (int j = 0; j < chessBoard[colNum].length; j++) {
                chessBoard[j][rowNum] = 0;
            }

            if (chessBoard[colNum][rowNum] != 0) {
                continue;
            }

            if (checkProfit(chessBoard, colNum, rowNum)) {
                chessBoard[colNum][rowNum] = 1;
                if (putChess(chessBoard, rowNum + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkProfit(int[][] chessBoard, int i, int j) {
        //check column
        for (int[] aChessBoard : chessBoard) {
            if (aChessBoard[j] != 0) {
                return false;
            }
        }

        //check row
        for (int k = 0; k < chessBoard.length; k++) {
            if (chessBoard[i][k] != 0) {
                return false;
            }
        }

        //check left up
        int m = i, n = j;
        while (m >= 0 && n >= 0) {
            if (chessBoard[m][n] != 0) {
                return false;
            }
            m--;
            n--;
        }

        //check right up
        m = i;
        n = j;
        while (m >= 0 && n < chessBoard.length) {
            if (chessBoard[m][n] != 0) {
                return false;
            }
            m--;
            n++;
        }

        //check left down
        m = i;
        n = j;
        while (m < chessBoard.length && n >= 0) {
            if (chessBoard[m][n] != 0) {
                return false;
            }
            m++;
            n--;
        }

        //check right down
        m = i;
        n = j;
        while (m < chessBoard.length && n < chessBoard.length) {
            if (chessBoard[m][n] != 0) {
                return false;
            }
            m++;
            n++;
        }
        return true;
    }

    private static int[][] initChessBoard(int n) {
        int[][] chessBoard = new int[n][n];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                chessBoard[i][j] = 0;
            }
        }
        return chessBoard;
    }
}
