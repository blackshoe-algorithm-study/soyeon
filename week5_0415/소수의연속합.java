package week5_0415;

import java.io.*;
import java.util.*;

public class 소수의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i=2; i<=n; i++) {
            if (isPrime(i)) primes.add(i);
        }
        primes.add(0);

        int cnt = 0;
        int sum = 0;
        int left = 0, right = 0;
        while (right < primes.size()) {
            if (sum < n) {
                sum += primes.get(right++);
                continue;
            }
            if (sum >= n) {
                if (sum == n) cnt++;
                sum -= primes.get(left++);
            }
        }

        System.out.print(cnt);
    }

    static boolean isPrime(int num) {
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
