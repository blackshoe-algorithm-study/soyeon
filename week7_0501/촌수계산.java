package week7_0501;

import java.io.*;
import java.util.*;

public class 촌수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 사람 수

        st = new StringTokenizer(br.readLine()); // 구해야하는 사람
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); // 관계 수
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++)
            map.put(i, new ArrayList<>());

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            map.get(parent).add(child);
            map.get(child).add(parent);
        }

        System.out.print(bfs(a, b, map, n));
    }

    static int bfs(int start, int target, Map<Integer, ArrayList<Integer>> map, int n) {
        boolean[] visited = new boolean[n+1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start, 0}); // {start, count}

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int person = curr[0];
            int cnt = curr[1];

            if (person == target) return cnt;

            for (int num : map.get(person)) {
                if (!visited[num]) {
                    q.offer(new int[] {num, cnt + 1});
                    visited[num] = true;
                }
            }
        }

        return -1;
    }
}
