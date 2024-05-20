package week10_0520;

import java.io.*;
import java.util.*;

public class 절댓값힙 {
    static class Node implements Comparable<Node> {
        int abs;
        int num;

        Node(int abs, int num) {
            this.abs = abs;
            this.num = num;
        }

        @Override
        public int compareTo(Node other) {
            if (this.abs == other.abs) return Integer.compare(this.num, other.num);
            return Integer.compare(this.abs, other.abs);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                pq.offer(new Node(Math.abs(num), num));
            } else {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll().num).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
