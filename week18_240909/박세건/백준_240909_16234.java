import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, L, R;
    private static int answer = 0;

    private static int[][] map;

    private static int[] dix = {-1, 0, 1, 0};
    private static int[] diy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        setting();
        solve();
        System.out.println(answer - 1);
    }

    private static void solve() {
        boolean isContinue = true;
        while (isContinue) {
            isContinue = false;
            boolean[][][] isOpen = new boolean[N][N][4];
            /*
             *   차이가 L,R 사이인지 확인
             * */
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 4; k++) {
                        int dx = i + dix[k];
                        int dy = j + diy[k];
                        if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
                            continue;
                        }
                        int diff = Math.abs(map[i][j] - map[dx][dy]);
                        if (L <= diff && diff <= R) {
                            isOpen[i][j][k] = true;
                        }
                    }
                }
            }

            int[][] visited = new int[N][N];
            int curVal = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] != 0) {
                        continue;
                    }
                    visited[i][j] = curVal;
//                System.out.println(i + " " + j + " " + isOpen[i][j][0] + " " + isOpen[i][j][1] + " " + isOpen[i][j][2] + " " + isOpen[i][j][3]);
                    int[] result = DFS(i, j, 1, map[i][j], visited, isOpen, curVal);
//                    System.out.println(result[0] + " " + result[1]);
                    if (result[1] < 2) {
                        visited[i][j] = 0;
                        continue;
                    }
                    isContinue = true;
                    changeMap(visited, curVal, result[0] / result[1]);
                    curVal++;

                }
            }
//            for (int k = 0; k < N; k++) {
//                for (int l = 0; l < N; l++) {
//                    System.out.print(map[k][l] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//            System.out.println();
            answer++;
        }

    }

    private static void changeMap(int[][] visited, int curVal, int val) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
//                System.out.print(visited[i][j] + " ");
                if (visited[i][j] == curVal) {
                    map[i][j] = val;
                }
            }
//            System.out.println();
        }
    }

    private static int[] DFS(int x, int y, int cnt, int sum, int[][] visited, boolean[][][] isOpen, int curVal) {
//        System.out.println(x + " " + y + " " + isOpen[x][y][0] + " " + isOpen[x][y][1] + " " + isOpen[x][y][2] + " " + isOpen[x][y][3]);
//        System.out.println(x + " " + y + " " + cnt + " " + sum);
        int[] curAnswer = {sum, cnt};
        for (int i = 0; i < 4; i++) {
            int dx = x + dix[i];
            int dy = y + diy[i];
//            if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
//
//                System.out.println(dx + " " + dy + " " + i + " " + visited[dx][dy] + " " + isOpen[dx][dy][i]);
//            }
            if (dx < 0 || dx >= N || dy < 0 || dy >= N || visited[dx][dy] != 0 || !isOpen[x][y][i]) {
                continue;
            }
//            System.out.println(dx + " " + dy + " " + isOpen[x][y][0] + " " + isOpen[x][y][1] + " " + isOpen[x][y][2] + " " + isOpen[x][y][3]);
            visited[dx][dy] = curVal;
            int[] nextAnswer = DFS(dx, dy, 1, map[dx][dy], visited, isOpen, curVal);
            curAnswer[0] += nextAnswer[0];
            curAnswer[1] += nextAnswer[1];
        }
        return curAnswer;
    }

    private static void setting() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }


}
