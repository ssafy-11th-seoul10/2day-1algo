import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7569 {

    static int[] dx = {0, 0, -1, 1, 0, 0}, dy = {1, -1, 0, 0, 0, 0}, dh = {0, 0, 0, 0, 1, -1};
    static int M, N, H, boxes[][][];
    static int result;
    static boolean visited[][][];
    static Queue<int[]> queue;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boxes = new int[N][M][H];
        queue = new LinkedList<>();
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    boxes[j][k][i] = Integer.parseInt(st.nextToken());
                    if (boxes[j][k][i] == 1) queue.offer(new int[]{j, k, i, 0});
                }
            }
        }

        visited = new boolean[N][M][H];
        result = 0;
        if (end()){
            System.out.println(0);
        } else {
            bfs();
            if (end()) {
                System.out.println(result);
            } else {
                System.out.println(-1);
            }
        }

    }

    static void bfs(){
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            int h = arr[2];
            int cnt = arr[3];
            visited[x][y][h] = true;
            result = Math.max(result, cnt);

            for (int i = 0; i < 6; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                int c = h + dh[i];
                if (valid(a, b, c) && !visited[a][b][c] && boxes[a][b][c] == 0) {
                    boxes[a][b][c] = 1;
                    queue.offer(new int[]{a, b, c, cnt+1});
                }
            }
        }
    }

    static boolean end() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (boxes[i][j][k] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean valid(int x, int y, int h){
        if (x > -1 && x < N && y >-1 && y < M && h > -1 && h < H){
            return true;
        } else {
            return false;
        }
    }
}
