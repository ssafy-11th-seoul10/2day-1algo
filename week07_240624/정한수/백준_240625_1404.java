import java.io.*;
import java.util.*;

public class Main {

    private static int[][] probs;

    private static double get1stWinProb(int n){
        return probs[n][n ^ 1] / 100.0;
    }
    private static double get2ndWinProb(int n){
        return get1stWinProb(n) *
                (probs[n][n ^ 2] * get1stWinProb(n ^ 2)
                + probs[n][n ^ 3] * get1stWinProb(n ^ 3)) / 100.0;
    }
    private static double getFinalWinProb(int n){
        return get2ndWinProb(n) *
                (probs[n][n ^ 4] * get2ndWinProb(n ^ 4)
                + probs[n][n ^ 5] * get2ndWinProb(n ^ 5)
                + probs[n][n ^ 6] * get2ndWinProb(n ^ 6)
                + probs[n][n ^ 7] * get2ndWinProb(n ^ 7)) / 100.0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        probs = new int[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = i; j < 8; j++){
                if (i != j) {
                    int prob = Integer.parseInt(st.nextToken());
                    probs[i][j] = prob;
                    probs[j][i] = 100 - prob;
                }
            }
        }

        for (int i = 0; i < 8; i++){
            sb.append(getFinalWinProb(i)).append(' ');
        }
        System.out.println(sb);
    }

}
