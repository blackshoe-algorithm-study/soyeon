package week10_0522;

import java.io.*;
import java.util.*;

public class 덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Integer, Integer> map = new HashMap<>(); // 인덱스, 등수
        int n = Integer.parseInt(br.readLine());

        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            people[i] = new int[] {w, h};
            map.put(i, 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int[] current = people[i];
                int[] target = people[j];

                if (current[0] < target[0] && current[1] < target[1]) {
                    map.put(i, map.get(i) + 1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }
}
