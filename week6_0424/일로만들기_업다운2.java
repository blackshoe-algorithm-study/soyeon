package week6_0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일로만들기_업다운2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];

        Arrays.fill(d, Integer.MAX_VALUE);

        // 탑다운 - 통과
        d[1] = 0;
        System.out.print(recursion(d, n));
    }

    public static int recursion(int[] d, int n) {
        if (d[n] != Integer.MAX_VALUE) return d[n];

        if (n % 3 == 0) {
            d[n] = Math.min(d[n], recursion(d, n / 3) + 1);
        }
        if (n % 2 == 0) {
            d[n] = Math.min(d[n],  recursion(d, n / 2) + 1);
        }
        d[n] = Math.min(d[n], recursion(d, n - 1) + 1);

        return d[n];
    }
}
