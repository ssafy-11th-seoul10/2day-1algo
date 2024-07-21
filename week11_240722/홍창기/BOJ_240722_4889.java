import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240722_4889 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int ti = 1;; ti++) {
            String pars = br.readLine();

            if (pars.charAt(0) == '-') {
                break;
            }

            int ans = 0;
            int curDepth = 0;

            for (int i = 0; i < pars.length(); i++) {
                if (pars.charAt(i) == '{') {
                    curDepth++;
                } else {
                    if (--curDepth == -1) {
                        curDepth = 1;
                        ans++;
                    }
                }
            }

            ans += curDepth / 2;
            sb.append(ti).append(". ").append(ans).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}
