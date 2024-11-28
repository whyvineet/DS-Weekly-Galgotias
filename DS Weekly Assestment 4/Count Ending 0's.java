import java.util.Scanner;

public class TrailingZerosFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(countTrailingZeros(N));
        scanner.close();
    }

    public static int countTrailingZeros(int N) {
        int count = 0;
        for (long i = 5; N / i > 0; i *= 5) {
            count += N / i;
        }
        return count;
    }
}