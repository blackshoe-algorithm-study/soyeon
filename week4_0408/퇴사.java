package week4_0408;

import java.io.*;
import java.util.*;

public class 퇴사 {
    static int maxProfit = 0;
    public static void main(String[] args) throws IOException {
        // i는 1부터 n까지, Ti+i-1까지는 상담 못함(Ti+i부터 상담 가능), Ti+i < n
        // 완탐해서 배열에 수익 모두 넣고 max로 출력하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] days = new int[n+1][2];

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Ti = Integer.parseInt(st.nextToken());
            int Pi = Integer.parseInt(st.nextToken());
            days[i] = new int[] {Ti, Pi};
        }

        recursion(1, n, days, 0);

        System.out.println(maxProfit);
    }

    public static void recursion(int day, int n, int[][] days, int income) {
        // 퇴사 날짜를 넘어가면 종료
        if (day > n) {
            maxProfit = Math.max(maxProfit, income);
            return;
        }

        // 현재 상담을 선택한 경우
        if (day + days[day][0] - 1 <= n) { // 상담 기간이 퇴사 전까지인 경우
            recursion(day + days[day][0], n, days, income + days[day][1]);
        }

        // 현재 상담을 선택하지 않은 경우
        recursion(day + 1, n, days, income);
    }
}
