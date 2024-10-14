import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int answer = 0;
    private static int[][] map;

    private static int dix[] = {-1, 0, 1, 0};
    private static int diy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (true) {
            boolean isEnd = true;
            int[][] tmpMap = new int[N][M];
            copyMap(tmpMap, map);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tmpMap[i][j] != 0) {
                        isEnd = false;
                        int minusCnt = getMinusCnt(i, j);
                        tmpMap[i][j] = Math.max(tmpMap[i][j] - minusCnt, 0);
                    }
                }
            }
            answer++;
            if (isEnd) {
                answer = 0;
                break;
            }
            copyMap(map, tmpMap);
            if (!isOneGround()) {
                break;
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        System.out.println(answer);
    }

    private static void copyMap(int[][] copyMap, int[][] originMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = originMap[i][j];
            }
        }
    }

    private static boolean isOneGround() {
        boolean[][] visited = new boolean[N][M];
        boolean isRun = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    if (isRun) {
                        return false;
                    }
                    searchGround(i, j, visited);
                    isRun = true;
                }
            }
        }
        return true;
    }

    private static void searchGround(int x, int y, boolean[][] visited) {

        visited[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
//            System.out.println("x : " + cur[0] + " y : " + cur[1]);
            for (int i = 0; i < 4; i++) {
                int dx = cur[0] + dix[i];
                int dy = cur[1] + diy[i];
                if (dx < 0 || dx >= N || dy < 0 || dy >= M) {
                    continue;
                }
                if (visited[dx][dy]) {
                    continue;
                }
                if (map[dx][dy] != 0) {
                    visited[dx][dy] = true;
                    queue.add(new int[]{dx, dy});
                }
            }
        }
    }

    private static int getMinusCnt(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int dx = x + dix[i];
            int dy = y + diy[i];
            if (dx < 0 || dx >= N || dy < 0 || dy >= M) {
                continue;
            }
            if (map[dx][dy] == 0) {
                cnt++;
            }
        }
        return cnt;

    }

}
