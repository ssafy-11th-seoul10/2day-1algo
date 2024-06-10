import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240610_1398 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String n = br.readLine();
            int nLen = n.length();
            int[] digits = new int[nLen];

            for (int i = 0; i < nLen; i++) {
                digits[i] = n.charAt(nLen - i - 1) - '0';
            }

            int ans = 0;

            for (int i = 1; i < nLen; i += 2) {
                if (digits[i - 1] >= 5 && digits[i] >= 2) {
                    digits[i - 1] -= 5;
                    digits[i] -= 2;
                    ans++;
                }

                if (digits[i] >= 5) {
                    digits[i] -= 5;
                    ans += 2;
                }

                ans += digits[i - 1] + digits[i];
            }

            if (nLen % 2 == 1) {
                ans += digits[nLen - 1];
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}
