package week12_0605;

import java.io.*;
import java.util.*;

public class 오목 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] board = new int[19][19];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean found = false;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                int current = board[i][j];
                if (current != 0) {
                    if (find(board, i, j, current)) {
                        System.out.println(current);
                        System.out.print(i+1 + " ");
                        System.out.print(j+1);
                        found = true;
                        break;
                    }
                }
            }
            if (found) break;
        }

        if (!found) System.out.println(0);
    }

    static boolean find(int[][] board, int row, int col, int target) {
        // 아래 방향 검사
        if (
                inRange(row + 1, row + 2, row + 3, row + 4, row + 5, row + 6) &&
                board[row + 1][col] == target && board[row + 2][col] == target &&
                board[row + 3][col] == target && board[row + 4][col] == target &&
                (board[row + 5][col] != target || (board[row + 5][col] == target && board[row + 6][col] == target))
        ) {
            return true;
        }

        // 오른쪽 방향 검사
        if (
                inRange(col + 1, col + 2, col + 3, col + 4, col + 5, col + 6) &&
                board[row][col + 1] == target && board[row][col + 2] == target &&
                board[row][col + 3] == target && board[row][col + 4] == target &&
                (board[row][col + 5] != target || (board[row][col + 5] == target && board[row][col + 6] == target))
        ) {
            return true;
        }

        // 오른쪽 대각선 방향 검사
        if (
                inRange(row + 1, row + 2, row + 3, row + 4, row + 5, row + 6) &&
                inRange(col + 1, col + 2, col + 3, col + 4, col + 5, col + 6) &&
                board[row + 1][col + 1] == target && board[row + 2][col + 2] == target &&
                board[row + 3][col + 3] == target && board[row + 4][col + 4] == target &&
                (board[row + 5][col + 5] != target || (board[row + 5][col + 5] == target && board[row + 6][col + 6] == target))
        ) {
            return true;
        }

        // 왼쪽 대각선 방향 검사
        if (
                inRange(row - 1, row - 2, row - 3, row - 4, row - 5, row - 6) &&
                inRange(col - 1, col - 2, col - 3, col- 4, col - 5, col -6) &&
                board[row - 1][col - 1] == target && board[row - 2][col - 2] == target &&
                board[row - 3][col - 3] == target && board[row - 4][col - 4] == target &&
                (board[row - 5][col - 5] != target || (board[row - 5][col - 5] == target && board[row - 6][col - 6] == target))
        ) {
            return true;
        }

        return false;
    }

    static boolean inRange(int num) {
        return num <
    }
}
