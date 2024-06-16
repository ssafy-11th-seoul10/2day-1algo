import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240616_2999 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        int r = (int) Math.floor(Math.sqrt(n));

        while (r > 1 && n % r != 0) {
            r--;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < r; i++) {
            for (int j = i; j < n; j += r) {
                sb.append(s.charAt(j));
            }
        }

        System.out.println(sb);
        br.close();
    }

}
