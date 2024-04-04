package week3_0403;

import java.io.*;
import java.util.*;

public class 빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] height = new int[w];
        int[] leftMaxHeight = new int[w];
        int[] totalMaxHeight = new int[w];

        st = new StringTokenizer(br.readLine());
        int leftMax = Integer.MIN_VALUE;
        for (int i=0; i<w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            leftMax = Math.max(leftMax, height[i]);
            leftMaxHeight[i] = leftMax;
        }

        int rightMax = Integer.MIN_VALUE;
        for (int i=w-1; i>=0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            totalMaxHeight[i] = Math.min(rightMax, leftMaxHeight[i]);
            answer += totalMaxHeight[i] - height[i];
        }

        System.out.println(answer);
    }
}
