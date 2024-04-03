package week3_0403;

import java.io.*;
import java.util.*;

public class 진법변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Character, Integer> map = new HashMap<>();

        char current = 'A';

        // A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
        for (int i=0; i<26; i++) {
            map.put(current++, i+10);
        }

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int sum = 0;
         for (int i=0; i<N.length(); i++) {
             if (Character.isDigit(N.charAt(i))) {
                 sum += (N.charAt(i) - '0') * Math.pow(B, N.length() - i - 1);
             } else {
                 sum += map.get(N.charAt(i)) * Math.pow(B, N.length() - i - 1);
             }
         }

        System.out.println(sum);
    }
}
