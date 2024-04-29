package week7_0429;

import java.io.*;
import java.util.*;

public class 미로탐색 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = row.charAt(j) - '0';
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1}); // {x, y, 이동칸수}
        visited[0][0] = true;

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int cnt = curr[2];

            if (x == m - 1 && y == n - 1) {
                answer = cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (board[ny][nx] == 1 && !visited[ny][nx]) {
                    queue.offer(new int[] {nx, ny, cnt + 1});
                    visited[ny][nx] = true;
                }
            }
        }

        System.out.print(answer);
    }
}
