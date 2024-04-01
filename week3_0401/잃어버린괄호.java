package week3_0401;

import java.io.*;
import java.util.*;

public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] subtract = br.readLine().split("-");

        int sum = Integer.MAX_VALUE;

        for (int i=0; i<subtract.length; i++) {
            int temp = 0;

            String[] plus = subtract[i].split("\\+");

            for (String num : plus) {
                temp += Integer.parseInt(num);
            }

            if (sum == Integer.MAX_VALUE) sum = temp;
            else sum -=temp;
        }

        System.out.println(sum);
    }
}
