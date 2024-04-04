package week3_0403;

import java.io.*;
import java.util.*;

public class 수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, 0);
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) System.out.println(1);
            else System.out.println(0);
        }
    }
}
