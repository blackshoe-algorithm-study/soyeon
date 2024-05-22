package week10_0522;

import java.io.*;
import java.util.*;

public class 용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = 2_000_000_000;
        int a = 0;
        int b = 0;

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                a = arr[left];
                b = arr[right];
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(a + " " + b);
    }
}
