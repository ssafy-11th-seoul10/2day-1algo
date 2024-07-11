BFS(Queue에 map을 저장하며 해결)
  - 위쪽과, 오른쪽으로 이동시키는 것은 예외로 왼쪽위가 아닌 오른쪽 아래부터 탐색하며 진행(96라인)
  - 이미 한번 합쳐진 블럭은 다시 합쳐지지 않는다는 예외
    - 현재 이동중인 블럭이 합쳐졌는지를 확인 + 이동이 끝났을때 그 블록이 합쳐진 블럭임을 기록해주는 visited 배열 사용

--------------------------------------------

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N;

    private static int[] dix = {-1, 0, 1, 0};
    private static int[] diy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        int[][] startMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                startMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(startMap));
    }

    private static int bfs(int[][] startMap) {
        int max = 0;
        Queue<int[][]> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.add(startMap);
        queue2.add(0);
        /*
         *   [x][y] 가 현재 합쳐진 공간인지를 알려주는
         *  배열로 진행했을때와 map으로 진행했을때 속도 차이 확인하기 추가로 clear 사용했을때 속도도 비교
         * */
        while (queue1.size() > 0) {
            int[][] cur = queue1.poll();
//            System.out.println("cur-------------------------------");
//            print(cur);
            int cnt = queue2.poll();
            if (cnt == 5) {
                max = Math.max(max, findMaxValue(cur));
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int[][] clone = new int[N][N];
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        clone[j][k] = cur[j][k];
                    }
                }
                int[][] next = moveByDir(clone, i);
//                System.out.println("next------------------------------");
//                print(next);
                queue1.add(next);
                queue2.add(cnt + 1);
            }
        }
        return max;
    }

    private static void print(int[][] next) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(next[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }

    private static int findMaxValue(int[][] cur) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(cur[i][j], max);
            }
        }
        return max;
    }

    private static int[][] moveByDir(int[][] next, int dir) {
        boolean[][] visited = new boolean[N][N];
        /*
         *   오른쪽으로 이동하는 모션은 예외처리
         * */
        if (dir == 1||dir==2) {
            for (int i = N; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    moveOne(i, j, next, dir, visited);
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    moveOne(i, j, next, dir, visited);
                }
            }
        }
        return next;
    }

    private static void moveOne(int x, int y, int[][] next, int dir, boolean[][] visited) {
        boolean isMerged = false;
        while (true) {
            int nx = x + dix[dir];
            int ny = y + diy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                break;
            }
            if (next[nx][ny] == 0) {
                next[nx][ny] = next[x][y];
                next[x][y] = 0;
                x = nx;
                y = ny;
            } else if (next[x][y] == next[nx][ny] && isMerged == false && visited[nx][ny] == false) {
                isMerged = true;
                next[nx][ny] += next[x][y];
                next[x][y] = 0;
                x = nx;
                y = ny;
            } else {
                break;
            }
        }
        if (isMerged) {
            visited[x][y] = true;
        }
    }

}
