import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] universe = new int[M][N];
        int[][] buf = new int[M][N];

        for (int i = 0; i < M; i++){

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                universe[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < N; j++){
                buf[i][j] = Arrays.binarySearch(universe[i], universe[i][j]);
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++){
            int hash = Arrays.hashCode(buf[i]);
            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        int pairs = 0;
        for (int num : map.values()){
            pairs += num * (num - 1) / 2;
        }

        System.out.println(pairs);
    }

}
