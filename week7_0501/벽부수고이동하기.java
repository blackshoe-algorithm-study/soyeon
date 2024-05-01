package week7_0501;

import java.io.*;
import java.util.*;

public class 벽부수고이동하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        // visited[n][m][0]은 벽을 아직 안 부순 경우의 방문 여부, visited[n][m][1]은 벽을 이미 부순 경우의 방문 여부
        boolean[][][] visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = row.charAt(j) - '0';
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0, 1}); // {x, y, breaking, count}

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int answer = -1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int breaking = curr[2];
            int cnt = curr[3];

            if (x == m - 1 && y == n - 1) {
                answer = cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                // 벽을 부수는 경우
                if (board[ny][nx] == 1 && breaking == 0 && !visited[ny][nx][1]) {
                    visited[ny][nx][1] = true;
                    q.offer(new int[] {nx, ny, 1, cnt + 1});
                }

                // 일반적인 이동
                if (board[ny][nx] == 0 && !visited[ny][nx][breaking]) {
                    visited[ny][nx][breaking] = true;
                    q.offer(new int[] {nx, ny, breaking, cnt + 1});
                }
            }
        }

        System.out.print(answer);
    }
}
