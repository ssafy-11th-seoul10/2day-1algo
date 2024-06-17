import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_240617_25957 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char[] c = new char[s.length()];

            for (int j = 0; j < s.length(); j++) {
                c[j] = s.charAt(j);
            }

            if (s.length() >= 2) {
                Arrays.sort(c, 1, s.length() - 1);
            }

            String ns = String.valueOf(c);
            map.put(ns, s);
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            String s = st.nextToken();
            char[] c = new char[s.length()];

            for (int j = 0; j < s.length(); j++) {
                c[j] = s.charAt(j);
            }

            if (s.length() >= 2) {
                Arrays.sort(c, 1, s.length() - 1);
            }

            String ns = String.valueOf(c);
            sb.append(map.get(ns)).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

}
