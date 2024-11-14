import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        
        int K = scanner.nextInt();
        System.out.println(countSubarraysDivByK(A, K));
    }

    public static int countSubarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);

        int cumulativeSum = 0;
        int count = 0;

        for (int num : A) {
            cumulativeSum += num;
            int remainder = cumulativeSum % K;

            if (remainder < 0) remainder += K;

            count += remainderCount.getOrDefault(remainder, 0);

            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}