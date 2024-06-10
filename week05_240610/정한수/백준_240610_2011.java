import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        int[][] dp = new int[code.length()][2];

        if (code.charAt(0) == '0'){
            System.out.println(0);
            return;
        }

        if (code.length() == 1){
            System.out.println(1);
            return;
        }

        dp[0][1] = 1;
        if ((code.charAt(0) & 15) * 10 + (code.charAt(1) & 15) <= 26){
            dp[1][0] = 1;
        }
        if (code.charAt(1) != '0') {
            dp[1][1] = 1;
        }
        if (dp[1][0] + dp[1][1] == 0){
            System.out.println(0);
            return;
        }

        for (int i = 2; i < code.length(); i++){
            if (code.charAt(i - 1) != '0' && (code.charAt(i - 1) & 15) * 10 + (code.charAt(i) & 15) <= 26) {
                dp[i][0] = dp[i - 2][0] + dp[i - 2][1];
            }
            if (code.charAt(i) != '0') {
                dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
            }
            if (dp[i][0] + dp[i][1] == 0){
                System.out.println(0);
                return;
            }
            dp[i][0] %= 1000000;
            dp[i][1] %= 1000000;
        }

        System.out.println((dp[dp.length - 1][0] + dp[dp.length - 1][1]) % 1000000);
    }

}
