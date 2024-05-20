package week10_0520;

import java.io.*;
import java.util.*;

public class 문제집 {
    static class Node implements Comparable<Node> {
        int key;
        Integer prior;

        Node(int key, Integer prior) {
            this.key = key;
            this.prior = prior;
        }

        @Override
        public int compareTo(Node other) {
            return this.key - other.key;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int prior = Integer.parseInt(st.nextToken());
            pq.offer(new Node(key, prior));
            visited[key] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) pq.offer(new Node(i, null));
        }

        System.out.println(sb);
    }
}
