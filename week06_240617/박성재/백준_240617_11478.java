import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 백준_240617_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        HashSet<String> set = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                String subString = s.substring(j, j + i + 1);
                set.add(subString);
            }
        }

        sb.append(set.size()).append("\n");
        System.out.println(sb);
    }
}
