import java.io.*;
import java.util.*;

public class Main {

    private static int W, L, K;

    private static int modulo(int n){
        if (n >= 0){
            return n % K;
        }
        return (n + (1 - n / K) * K) % K;
    }

    private static int getWinningRating(int score, int winRating){
        return score + winRating;
    }

    private static int getLosingRating(int score, int lossRating){
        if (modulo(score) == 0){
            return score - Math.min(lossRating, K);
        }
        return score - Math.min(lossRating, modulo(score));
    }

    private static int getMaxScore(int[] winRatings, int[] lossRatings){
        int[][] dp = new int[W + 1][L + 1];

        for (int w = 1; w <= W; w++){
            dp[w][0] = getWinningRating(dp[w - 1][0], winRatings[w - 1]);
        }
        for (int l = 1; l <= L; l++){
            dp[0][l] = getLosingRating(dp[0][l - 1], lossRatings[l - 1]);
        }

        for (int w = 1; w <= W; w++){
            for (int l = 1; l <= L; l++){
                dp[w][l] = Math.max(getWinningRating(dp[w - 1][l], winRatings[w - 1]), getLosingRating(dp[w][l - 1], lossRatings[l - 1]));
            }
        }
        return dp[W][L];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        W = Integer.parseInt(br.readLine());
        int[] winRatings = new int[W];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < W; i++){
            winRatings[i] = Integer.parseInt(st.nextToken());
        }

        L = Integer.parseInt(br.readLine());
        int[] lossRatings = new int[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < L; i++){
            lossRatings[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        System.out.println(getMaxScore(winRatings, lossRatings));
    }
    
}
