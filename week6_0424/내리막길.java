package week6_0424;

import java.io.*;
import java.util.*;

public class 내리막길 {
    static int m;
    static int n;
    static int[][] map;
    static boolean[][] visited;
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
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.print(cnt);
    }

    static void dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            cnt++;
            for (boolean[] row : visited)
                Arrays.fill(row, false);
            return;
        }

        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;

            if (map[y][x] > map[ny][nx])
                dfs(nx, ny);
        }
    }
}
