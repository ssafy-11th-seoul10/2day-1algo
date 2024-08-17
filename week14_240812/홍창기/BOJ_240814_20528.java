import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240814_20528 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        char c = st.nextToken().charAt(0);
        int ans = 1;

        for (int i = 1; i < n; i++) {
            if (st.nextToken().charAt(0) != c) {
                ans = 0;
            }
        }

        System.out.println(ans);
        br.close();
    }

}
