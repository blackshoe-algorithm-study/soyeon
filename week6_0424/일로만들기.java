package week6_0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];

        Arrays.fill(d, Integer.MAX_VALUE);
        // 바텀업
        d[1] = 0;

        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
            if (i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
            d[i] = Math.min(d[i], d[i - 1] + 1);
        }

        System.out.print(d[n]);
    }
}
