import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        System.out.println(countSubstringsWithAllChars(s));
    }
    
    private static int countSubstringsWithAllChars(String s) {
        int left = 0, right = 0;
        int count = 0;
        
        int[] charCount = new int[3];
        
        while (right < s.length()) {
            charCount[s.charAt(right) - 'a']++;
            
            while (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                count += s.length() - right;
                
                charCount[s.charAt(left) - 'a']--;
                left++;
            }
            
            right++;
        }
        
        return count;
    }
}