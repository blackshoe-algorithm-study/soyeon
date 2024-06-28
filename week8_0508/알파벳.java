package week8_0508;

import java.io.*;
import java.util.*;

public class 알파벳 {
    static int R;
    static int C;
    static int max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Character[][] board = new Character[R][C];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        dfs(board, visited, 0, 0, 1);

        System.out.println(max);
    }

    static void dfs(Character[][] board, boolean[] visited, int x, int y, int count) {
        visited[board[y][x] - 65] = true;

        max = Math.max(max, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= C || ny < 0 || ny >= R) continue;
            if (visited[board[ny][nx] - 65]) continue;
            dfs(board, visited, nx, ny, count + 1);
            visited[board[ny][nx] - 65] = false;
        }
    }
}
