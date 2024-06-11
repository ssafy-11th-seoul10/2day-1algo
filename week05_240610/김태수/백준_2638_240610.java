import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int cheeseNum = 0;
    static int time = 0;
    static int[][] map;
    static int[][] air;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    cheeseNum++;
                }
            }
        }

        while (cheeseNum != 0) {
            cheese();
        }

        System.out.println(time);
    }

    static void cheese() {
        air = new int[N][M];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        air[0][0] = -1;

        while (!q.isEmpty()) {
            Node a = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = a.y + dy[i];
                int moveX = a.x + dx[i];

                if (moveY < 0 || moveX < 0 || moveY >= N || moveX >= M) {
                    continue;
                }

                if (map[moveY][moveX] == 1) {
                    air[moveY][moveX]++;
                }
                if (map[moveY][moveX] == 0 && air[moveY][moveX] == 0) {
                    air[moveY][moveX] = -1;
                    q.offer(new Node(moveY, moveX));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (air[i][j] >= 2) {
                    cheeseNum--;
                    map[i][j] = 0;
                }
            }
        }
        time++;
    }
}

class Node {
    int y;
    int x;

    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
