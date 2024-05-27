package week11_0527;

import java.io.*;
import java.util.*;

public class 시험감독 {
    public static void main(String[] args) throws IOException {
        // 같은 명 수에 대해 메모이제이션
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] memo = new int[1_000_001];

        int n = Integer.parseInt(br.readLine());
        int[] classes = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            classes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long count = 0;
        for (int i = 0; i < n; i++) {
            if (memo[classes[i]] == 0) {
                int diff = Math.max(classes[i] - b, 0); // 이 코드가 중요
                float sub = (float) diff / c;
                memo[classes[i]] = (int) Math.ceil(sub);
            }
            count += memo[classes[i]] + 1;
        }

        System.out.println(count);
    }
}
