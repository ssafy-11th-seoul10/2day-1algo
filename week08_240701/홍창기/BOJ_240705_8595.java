import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240705_8595 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long ans = 0;
        int curNum = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                curNum = curNum * 10 + c - '0';
            } else {
                ans += curNum;
                curNum = 0;
            }
        }

        ans += curNum;
        System.out.println(ans);
        br.close();
    }

}
