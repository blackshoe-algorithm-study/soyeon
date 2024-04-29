package week7_0429;

import java.io.*;
import java.util.*;

public class 숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {n, 0}); // {수빈, 이동횟수}

        boolean[] visited = new boolean[100001];

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int subin = curr[0];
            int count = curr[1];

            if (subin == k) {
                answer = count;
                break;
            }

            if (subin > 0 && !visited[subin - 1]) {
                queue.offer(new int[]{subin - 1, count + 1});
                visited[subin - 1] = true;
            }
            if (subin != 100000 && !visited[subin + 1]) {
                queue.offer(new int[]{subin + 1, count + 1});
                visited[subin + 1] = true;
            }
            if (subin <= 50000 && !visited[subin * 2]) {
                queue.offer(new int[]{subin * 2, count + 1});
                visited[subin * 2] = true;
            }
        }

        System.out.print(answer);
    }
}
