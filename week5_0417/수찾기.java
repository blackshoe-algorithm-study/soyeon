package week5_0417;

import java.io.*;
import java.util.*;

public class 수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nArr = new int[n];
        for (int i=0; i<n; i++) nArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nArr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (find(nArr, num)) System.out.println(1);
            else System.out.println(0);
        }
    }

    static boolean find(int[] arr, int num) {
        int start = 0, end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] > num) end = mid - 1;
            if (arr[mid] < num) start = mid + 1;
            if (arr[mid] == num) return true;
        }
        return false;
    }
}
