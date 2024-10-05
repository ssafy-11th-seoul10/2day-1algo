
import java.util.*;
import java.io.*;

public class Main {

    static int N, Count;
    static int[][] board;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y< N);
    }

    static int sharkSize = 2;
    static int sharkX, sharkY;

    // Func
    public static boolean check() {

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                if(board[i][j] != 0 && board[i][j] < sharkSize)
                    return true;

        return false;
    }

    public static int moveAndEat() {

        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> getFish = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];

        visited[sharkX][sharkY] = true;
        queue.add(new int[] {0, sharkX, sharkY});

        while (!queue.isEmpty()) {

            int[] pos = queue.poll();
            int curX = pos[1]; int curY = pos[2];

            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(inRange(nx, ny) && !visited[nx][ny]) {

                    if(board[nx][ny] <= sharkSize) {

                        visited[nx][ny] = true;
                        queue.add(new int[] {pos[0] + 1, nx, ny});

                        if(board[nx][ny] != 0 && board[nx][ny] < sharkSize) {
                            getFish.add(new int[] {pos[0] + 1, nx, ny});
                        }

                    }
                }
            }
        }
        // 물고기까지 도달하지 못하는 경우..
        if(getFish.isEmpty())
            return 0;

        getFish.sort((f1, f2) -> {
            if(f1[0] == f2[0]) {
                if(f1[1] == f2[1])
                    return f1[2] - f2[2];
                return f1[1] - f2[1];
            }
            return f1[0] - f2[0];
        });

        int[] getF = getFish.get(0);

        board[sharkX][sharkY] = 0;
        board[getF[1]][getF[2]] = 9;
        sharkX = getF[1]; sharkY = getF[2];

        // eaten!
        return getF[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Count = 0;
        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

        // Simulation
        int eaten = 0;

        while (check()) {

            int getTime = moveAndEat();

            if(getTime == 0) // 먹을 수 있는 물고긴 존재 하지만, 갈 수 없을 경우
                break;
            else
                Count += getTime;

            eaten++;

            if(eaten == sharkSize) {
                sharkSize++;
                eaten = 0;
            }
        }

        System.out.println(Count);
    }
}
