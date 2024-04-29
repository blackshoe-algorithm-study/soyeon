package week7_0429;

import java.io.*;
import java.util.*;

public class 토마토 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1)
                    queue.offer(new int[] {j, i, 0}); // {x, y, 날짜카운트}
            }
        }

        int day = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int cnt = curr[2];

            day = Math.max(day, cnt);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[ny][nx] == 0) {
                    board[ny][nx] = 1; // 방문처리
                    queue.offer(new int[] {nx, ny, cnt + 1});
                }
            }
        }

        if (allRipen(board, m, n)) System.out.print(day);
        else System.out.print(-1);
    }

    static boolean allRipen(int[][] board, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (board[i][j] == 0) return false;
        }
        return true;
    }
}
