package week12_0605;

import java.io.*;
import java.util.*;

public class N과M1 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] checked = new boolean[n + 1];
        int[] chosen = new int[m];

        backtracking(n, m, chosen, 0, checked);

        System.out.println(sb);
    }

    static void backtracking(int n, int m, int[] chosen, int depth, boolean[] checked) {
        if (depth == m) {
            for (int num : chosen) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!checked[i]) {
                chosen[depth] = i;
                checked[i] = true;
                backtracking(n, m, chosen, depth + 1, checked);
                checked[i] = false;
            }
        }
    }
}
