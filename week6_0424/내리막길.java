package week6_0424;

import java.io.*;
import java.util.*;

public class 내리막길 {
    static int m;
    static int n;
    static int[][] map;
    static int[][] dp;
    static int cnt = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];

        for (int[] row : dp) Arrays.fill(row, -1);
        dp[m-1][n-1] = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.print(dp[0][0]);
    }

    static void dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) return;

        if (dp[y][x] != -1) return;

        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;

            if (map[y][x] > map[ny][nx]) {
                if (dp[ny][nx] != -1)
                    dp[y][x] += dp[ny][nx];
                else {
                    dfs(nx, ny);
                    dp[y][x] += dp[ny][nx];
                }
            }
        }
    }
}
