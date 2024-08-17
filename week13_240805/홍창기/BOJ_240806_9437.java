import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_240806_9437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            int p = Integer.parseInt(st.nextToken());
            int[] ans = new int[3];
            ans[0] = n + 1 - p;
            ans[1] = p % 2 == 0 ? p - 1 : p + 1;
            ans[2] = n + 1 - ans[1];

            Arrays.sort(ans);
            sb.append(ans[0]).append(' ').append(ans[1]).append(' ').append(ans[2]).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

}
