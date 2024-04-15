package week5_0415;

import java.io.*;
import java.util.*;

public class 배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int key = 0;
        for (int i=0; i<n; i++) {
            map.put(key++, Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            map.put(key++, Integer.parseInt(st.nextToken()));
        }

        List<Map.Entry<Integer,Integer>> entry = new ArrayList<>(map.entrySet());

        entry.sort(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Integer> e:entry) {
            bw.write(e.getValue() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
