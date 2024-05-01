package week7_0501;

import java.io.*;
import java.util.*;

public class 토마토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, n, -n};

        int row = n * h;
        int[][] board = new int[row][m];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < m; j++)
                if (board[i][j] == 1) q.offer(new int[] {j, i, 0}); // {x, y, day}
        }

        int day = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int cnt = curr[2];

            day = Math.max(day, cnt);

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= row) continue;
                if ((ny == y + 1 || ny == y - 1) && ny / n != y / n) continue;
                if (board[ny][nx] == 0) {
                    board[ny][nx] = 1; // 방문처리
                    q.offer(new int[] {nx, ny, cnt + 1});
                }
            }
        }

        if (allRipen(board, m, row)) System.out.print(day);
        else System.out.print(-1);
    }

    static boolean allRipen(int[][] board, int col, int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                if (board[i][j] == 0) return false;
        }
        return true;
    }
}
