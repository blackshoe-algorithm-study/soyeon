package week12_0605;

import java.io.*;
import java.util.*;

public class 날짜계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken()); // 1 ~ 15
        int S = Integer.parseInt(st.nextToken()); // 1 ~ 28
        int M = Integer.parseInt(st.nextToken()); // 1 ~ 19

        int e = 1;
        int s = 1;
        int m = 1;
        int year = 1;

        while (true) {
            if (e > 15) e = e % 15;
            if (s > 28) s = s % 28;
            if (m > 19) m = m % 19;

            if (e == E && s == S && m == M) {
                break;
            }

            e++;
            s++;
            m++;
            year++;
        }

        System.out.println(year);
    }
}
