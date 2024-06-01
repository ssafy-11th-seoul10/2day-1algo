import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1439_240601 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String s = st.nextToken();

        int[] count = new int[2];

        int num = s.charAt(0) - '0';
        count[num]++;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                num = s.charAt(i) - '0';
                count[num]++;
            }
        }

        if (count[0] == 0 || count[1] == 0) {
            sb.append(0).append("\n");
        } else {
            sb.append(Math.min(count[0], count[1])).append("\n");
        }

        System.out.println(sb);
    }
}
