package week6_0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일로만들기_업다운 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];

        Arrays.fill(d, Integer.MAX_VALUE);

        // 탑다운 - 시간초과
        d[n] = 0;
        recursion(d, n);
        System.out.print(d[1]);
    }

    public static void recursion(int[] d, int n) {
        if (n == 1) return;

        if (n % 3 == 0) {
            d[n / 3] = Math.min(d[n / 3], d[n] + 1);
            recursion(d, n / 3);
        }
        if (n % 2 == 0) {
            d[n / 2] = Math.min(d[n / 2], d[n] + 1);
            recursion(d, n / 2);
        }
        d[n - 1] = Math.min(d[n - 1], d[n] + 1);
        recursion(d, n - 1);
    }
}
