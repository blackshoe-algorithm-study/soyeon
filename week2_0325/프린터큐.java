package week2_0325;

import java.io.*;
import java.util.*;

public class 프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);
            }

            int count = 0; // m번째 요소가 몇 번째로 출력되는지 세기
            while (true) {
                Integer max = Collections.max(queue);
                int cur = queue.poll(); // popleft

                if (cur < max) {
                    queue.offer(cur); // 다시 큐 뒤에 붙이기

                    // 포인터 유지하기
                    if (m > 0) m--;
                    else if (m == 0) m = queue.size() - 1;
                } else {
                    // m == 0인 이유는 (index == 0) 일 때 poll하므로
                    if (m == 0) {
                        System.out.println(count + 1);
                        break;
                    } else {
                        // 내가 찾으려는 요소는 아님
                        m--;
                        count++;
                    }
                }
            }
        }

    }
}
