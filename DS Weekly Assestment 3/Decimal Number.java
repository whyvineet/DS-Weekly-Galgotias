import java.io.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine().trim();
            System.out.println(validate(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int validate(String s) {
        String regex = "^[ ]*[+-]?((\\d+\\.\\d*)|(\\d*\\.\\d+)|(\\d+))(e[+-]?\\d+)?[ ]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches() ? 1 : 0;
    }
}