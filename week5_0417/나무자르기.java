package week5_0417;

import java.io.*;
import java.util.*;

public class 나무자르기 {
    public static void main(String[] args) throws IOException {
        // 적어도 m미터를 가져가기 위해 최대 h 설정
        // 이분탐색 : height = sum(잘린 나머지들) >= m 일 때의 높이
        // answer = max(answer, height)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[n];
        for (int i=0; i<n; i++) trees[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(trees);

        int start = 0, end = trees[n-1];
        int height; // 현재 설정된 절단기 높이
        int answer = 0; // 절단기 높이의 최댓값
        long sum; // 잘린 나머지 나무 부분들의 합
        while (start <= end) {
            sum = 0;
            height = (start + end) / 2;

            for (int i=0; i<n; i++) {
                int diff = trees[i] - height; // 잘린 나머지 부분
                if (diff > 0) sum += diff;
            }

            if (sum >= m) {
                answer = Math.max(answer, height);
                start = height + 1; // height를 더 높여야 함
            }
            if (sum < m) end = height - 1; // height를 더 낮춰야 함
        }

        System.out.print(answer);
    }
}
