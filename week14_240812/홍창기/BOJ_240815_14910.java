import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240815_14910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        boolean ans = true;
        int x0 = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());

            if (x0 > x) {
                ans = false;
                break;
            }

            x0 = x;
        }

        System.out.println(ans ? "Good" : "Bad");
        br.close();
    }

}
