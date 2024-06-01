import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] color = new int[n][3];

        for (int i = 0; i < n; i++) {
            color[i][0] = sc.nextInt();
            color[i][1] = sc.nextInt();
            color[i][2] = sc.nextInt();
        }

        int minCost = 1000 * 1000;

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[n][3];

            for (int i = 0; i < 3; i++) {
                if (i == firstColor) {
                    dp[0][i] = color[0][i];
                } else {
                    dp[0][i] = 1000 * 1000;
                }
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + color[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + color[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + color[i][2];
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor != firstColor) {
                    minCost = Math.min(minCost, dp[n - 1][lastColor]);
                }
            }
        }

        System.out.println(minCost);
    }
}
