package week3_0401;

import java.io.*;
import java.util.*;

public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] numbers = new int[n][2];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            numbers[i] = new int[]{first, second};
        }

        Arrays.sort(numbers, (o1, o2) -> {
            if (o1[1] - o2[1] != 0) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });

        int end = 0;
        int count = 0;
        for (int i=0; i<n; i++) {
            if (numbers[i][0] >= end) {
                end = numbers[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
