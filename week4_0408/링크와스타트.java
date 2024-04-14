package week4_0408;

import java.io.*;
import java.util.*;

public class 링크와스타트 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        boolean[] checked = new boolean[n];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int teamNum=0; teamNum<n; teamNum++) {
            nCr(arr, 0, 0, teamNum, checked, n);
        }

        System.out.print(min);
    }

    static void nCr(int[][] arr, int depth, int startIdx, int teamNum, boolean[] checked, int n) {
        if (depth == teamNum) {
            int link = 0, start = 0;
            for (int i=0; i<n; i++) {
                for (int j=i; j<n; j++) {
                    if (checked[i] && checked[j]) link += (arr[i][j] + arr[j][i]);
                    if (!checked[i] && !checked[j]) start += (arr[i][j] + arr[j][i]);
                }
            }

            int diff = Math.abs(link - start);
            min = Math.min(min, diff);
            return;
        }

        for (int i=startIdx; i<n; i++) {
            checked[i] = true;
            nCr(arr, depth + 1, i + 1, teamNum, checked, n);
            checked[i] = false;
        }
    }
}
