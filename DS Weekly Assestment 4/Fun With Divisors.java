import java.util.Scanner;

public class NumbersWithThreeDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(countNumbersWithThreeDivisors(N));
        scanner.close();
    }

    public static int countNumbersWithThreeDivisors(int N) {
        int count = 0;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime(i)) {
                if (i * i <= N) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}