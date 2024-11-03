import java.util.*;

public class AnagramIndicesFinder {
    public static List<Integer> findAnagramIndices(String A, String B) {
        List<Integer> result = new ArrayList<>();
        
        if (A == null || B == null || A.length() < B.length()) {
            return result;
        }

        Map<Character, Integer> bCount = new HashMap<>();
        Map<Character, Integer> windowCount = new HashMap<>();

        for (char c : B.toCharArray()) {
            bCount.put(c, bCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < B.length(); i++) {
            char c = A.charAt(i);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
        }

        if (windowCount.equals(bCount)) {
            result.add(0);
        }

        for (int i = B.length(); i < A.length(); i++) {
            char newChar = A.charAt(i);
            char oldChar = A.charAt(i - B.length());

            windowCount.put(newChar, windowCount.getOrDefault(newChar, 0) + 1);

            if (windowCount.get(oldChar) == 1) {
                windowCount.remove(oldChar);
            } else {
                windowCount.put(oldChar, windowCount.get(oldChar) - 1);
            }

            if (windowCount.equals(bCount)) {
                result.add(i - B.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();

        List<Integer> anagramIndices = findAnagramIndices(A, B);
        System.out.println(anagramIndices);
    }
}