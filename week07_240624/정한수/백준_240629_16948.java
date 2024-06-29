import java.io.*;
import java.util.*;

public class Main {

    private static final int[][] D = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
    private static int N;

    private static int bfs(int[] sp, int[] ep){
        Queue<Integer> q = new ArrayDeque<>();
        BitSet visited = new BitSet();
        int move = 0;

        q.add(sp[0] * N + sp[1]);
        while (!q.isEmpty()){
            int size = q.size();

            move++;
            while(size-- > 0) {
                int tmp = q.remove();
                int i = tmp / N, j = tmp % N;

                for (int[] d : D) {
                    int nextI = i + d[0], nextJ = j + d[1];

                    if (nextI == ep[0] && nextJ == ep[1]) {
                        return move;
                    }

                    if (nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < N && !visited.get(nextI * N + nextJ)) {
                        visited.set(nextI * N + nextJ);
                        q.add(nextI * N + nextJ);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sp = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] ep = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        System.out.println(bfs(sp, ep));
    }

}
