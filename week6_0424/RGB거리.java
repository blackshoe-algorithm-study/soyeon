package week6_0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][3];
        int[][] d = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken()); // red
            board[i][1] = Integer.parseInt(st.nextToken()); // green
            board[i][2] = Integer.parseInt(st.nextToken()); // blue
        }

        d[0][0] = board[0][0];
        d[0][1] = board[0][1];
        d[0][2] = board[0][2];

        for (int i = 1; i < n; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + board[i][0];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + board[i][1];
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + board[i][2];
        }

        int min = Integer.MAX_VALUE;
        for (int num : d[n-1])
            if (num < min) min = num;

        System.out.print(min);
    }
}
