package week3_0401;

import java.io.*;
import java.util.*;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        Arrays.sort(nums);

        int answer = 0;
        for (int i=1; i<=n; i++) {
            for (int j=0; j<i; j++) {
                sum += nums[j];
            }
            answer += sum;
            sum = 0;
        }

        System.out.println(answer);
    }
}
