import java.io.*;
import java.util.*;

public class Main {

    private static final int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int[][] field;
    private static int N, M, maxSum;
    private static BitSet visited;

    private static boolean isUnavailable(int i, int j){
        return i < 0 || j < 0 || i >= N || j >= M || visited.get(i * M + j);
    }

    private static void backtracking(int center, int totalSum){
        if (center >= N * M){
            maxSum = Math.max(maxSum, totalSum);
            return;
        }

        if (!visited.get(center)) {
            int i = center / M, j = center % M;

            visited.set(center);
            for (int d = 0; d < 4; d++) {
                int wingI1 = i + D[d][0], wingJ1 = j + D[d][1];
                int wingI2 = i + D[(d + 1) % 4][0], wingJ2 = j + D[(d + 1) % 4][1];

                if (isUnavailable(wingI1, wingJ1) || isUnavailable(wingI2, wingJ2)) {
                    continue;
                }
                visited.set(wingI1 * M + wingJ1);
                visited.set(wingI2 * M + wingJ2);
                backtracking(center + 1, totalSum + 2 * field[i][j] + field[wingI1][wingJ1] + field[wingI2][wingJ2]);
                visited.clear(wingI1 * M + wingJ1);
                visited.clear(wingI2 * M + wingJ2);
            }
            visited.clear(center);
        }
        backtracking(center + 1, totalSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        visited = new BitSet(N * M);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);
        System.out.println(maxSum);
    }

}
