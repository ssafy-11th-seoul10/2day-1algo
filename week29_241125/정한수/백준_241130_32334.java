import java.io.*;
import java.util.*;

public class Main {

    private static int[] getIdealIndexAndNumberOfMagnets(int[][] nearbyMagnets, int N){
        int[] result = new int[3];

        result[2] = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (nearbyMagnets[i][j] == 0){
                    result[0] = i + 1;
                    result[1] = j + 1;
                    result[2] = 0;
                    return result;
                }
                if (nearbyMagnets[i][j] > 0 && result[2] > nearbyMagnets[i][j]){
                    result[0] = i + 1;
                    result[1] = j + 1;
                    result[2] = nearbyMagnets[i][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[][] nearbyMagnets = new int[N][N];
        int[][] field = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                if (field[i][j] == 0){
                    continue;
                }

                nearbyMagnets[i][j] = -1;
                for (int n = Math.max(i - D, 0); n <= Math.min(i + D, N - 1); n++){
                    for (int m = Math.max(j - D, 0); m <= Math.min(j + D, N - 1); m++){
                        if (nearbyMagnets[n][m] >= 0) {
                            nearbyMagnets[n][m]++;
                        }
                    }
                }
            }
        }

        int[] result = getIdealIndexAndNumberOfMagnets(nearbyMagnets, N);
        sb.append(result[0]).append(" ").append(result[1]);
        if (result[2] > 0){
            sb.append("\n").append(result[2]);
        }

        System.out.println(sb);
    }

}
