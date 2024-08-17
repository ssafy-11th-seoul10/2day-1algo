import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240812_17466 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long ans = 1;

        for (int i = 2; i <= n; i++) {
            ans = ans * i % p;
        }

        System.out.println(ans);
        br.close();
    }

}
