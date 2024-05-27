package week11_0527;

import java.io.*;
import java.util.*;

public class 예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] req = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            req[i] = Integer.parseInt(st.nextToken());
        }

        int total = Integer.parseInt(br.readLine());

        Arrays.sort(req);

        int answer = 0;

        int start = 0;
        int end = req[n - 1];
        int mid = (start + end) / 2;
        while (start <= end) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (req[i] <= mid) {
                    sum += req[i];
                } else {
                    sum += mid;
                }
            }

            if (sum > total) { // 상한이 너무 높다는 뜻
               end = mid - 1;
            }
            if (sum <= total) { // 상한을 더 높일 수 있다는 뜻
                start = mid + 1;
                answer = Math.max(answer, mid);
            }
            mid = (start + end) / 2; // 이 코드의 순서가 중요
        }

        System.out.println(answer);
    }
}
