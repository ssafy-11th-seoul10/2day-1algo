import java.io.*;

public class Main {

    private static int readInt() throws IOException {
        int c, n = 0;

        while((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[][] matrices = new int[N][];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++){
            matrices[i] = new int[]{readInt(), readInt()};
        }

        for (int k = 1; k < N; k++){
            for (int i = 0; i < N - k; i++){
                int minProd = Integer.MAX_VALUE;

                for (int j = i; j < i + k; j++){
                    minProd = Math.min(minProd, dp[i][j] + dp[j + 1][i + k] + matrices[i][0] * matrices[j][1] * matrices[i + k][1]);
                }
                dp[i][i + k] = minProd;
            }
        }
        System.out.println(dp[0][N - 1]);
    }

}
