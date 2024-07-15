import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_240715_17430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashSet<Integer> xx = new HashSet<Integer>();
            HashSet<Integer> yy = new HashSet<Integer>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                xx.add(x);
                yy.add(y);
            }

            if (n == (long) xx.size() * yy.size()) {
                sb.append("BALANCED\n");
            } else {
                sb.append("NOT BALANCED\n");
            }
        }

        System.out.print(sb);
        br.close();
    }

}
