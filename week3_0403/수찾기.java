package week3_0403;

import java.io.*;
import java.util.*;

public class 수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] n_list = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            n_list[i] = num;
        }

        Arrays.sort(n_list);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int result = Arrays.binarySearch(n_list, num);
            if (result >= 0) System.out.println(1);
            else System.out.println(0);
        }
    }
}
