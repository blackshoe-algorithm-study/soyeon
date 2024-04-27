package week6_0424;

import java.io.*;
import java.util.*;

public class 내리막길 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { 0, 0 });

        int cnt = 0;
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int x = curr[0];
            int y = curr[1];

            if (x == n - 1 && y == m - 1) {
                cnt++;
                for (boolean[] row : visited)
                    Arrays.fill(row, false);
                continue;
            }

            if (!visited[y][x]) {
                visited[y][x] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;

                    if (map[y][x] > map[ny][nx]) {
                        stack.push(new int[] { nx, ny });
                    }
                }
            }
        }

        System.out.print(cnt);
    }
}
