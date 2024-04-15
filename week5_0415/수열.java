package week5_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class 수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int left = 0, right = 0;
        int sum = 0, max = Integer.MIN_VALUE;
        while (right <= n) {
            if (cnt < k) {
                sum += arr[right++];
                cnt++;
                continue;
            }
            if (cnt == k) {
                max = Math.max(max, sum);
                sum -= arr[left++];
                sum += arr[right++];
            }
        }

        System.out.print(max);
    }
}
