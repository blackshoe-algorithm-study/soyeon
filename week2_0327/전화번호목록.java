package week2_0327;

import java.io.*;
import java.util.*;

public class 전화번호목록 {

    static class Node {
        Map<Character, Node> childeNodes = new HashMap<>();
        boolean isEnd;
    }

    static class Trie {
        Node rootNode = new Node();

        void insert(String str) {
            Node node = this.rootNode;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                node.childeNodes.putIfAbsent(c, new Node());
                node = node.childeNodes.get(c);
            }
            node.isEnd = true;
        }

        boolean search(String str) {
            Node node = this.rootNode;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                node = node.childeNodes.get(c);

                if (node == null) {
                    return false;
                }
            }

            if (node.isEnd) {
                if (node.childeNodes.isEmpty()) {
                    return false;
                }
            }
            return node.isEnd;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // 테스트 케이스마다 루프
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] nums = new String[n];
            boolean isConsistent = true;

            Trie trie = new Trie();

            boolean find = false;
            for (int j = 0; j < n; j++) {
                String num = br.readLine();
                trie.insert(num);
                nums[j] = num;
            }

            for (String num : nums) {
                if (trie.search(num)) {
                    isConsistent = false;
                    break;
                }
            }
            System.out.println(isConsistent ? "YES":"NO");
        }
    }
}