package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ16928 {

    static int N, M;
    static int result = 0;
    // 주사위 = 1 ~ 6

    static int[][] ladder;
    static int[][] snake;

    static int[] visited; // 0이면 갱신, 아니면 작은게 들어 가야 함

    public static void bfs() {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {1, 0});

        while (!queue.isEmpty()) {

            int[] tmp = queue.poll();
            int position = tmp[0]; int count = tmp[1];

            if(position == 100) {
                result = visited[100];
                return;
            }

            outer : for(int daiso = 1; daiso < 7; daiso++) {

                int next_position = position + daiso;

                if(next_position < 101 && (visited[next_position] == 0 || visited[next_position] > count + 1)) {
                    // 사다리와 뱀은 선택해서 타는 것이 아니라 해당 칸에 도착하면 반드시 이동을 해야 합니다.
                    // if문으로 작거나 한 번도 방문 한 적 없는 위치만 꺼내는 게 아니라, 일단 완탐..

                    boolean flag = false;

                    // 사다리인지?
                    for(int[] lad : ladder) {
                        if(lad[0] == next_position) {
                                visited[lad[0]] = count + 1;
                                visited[lad[1]] = count + 1;
                                queue.add(new int[] {lad[1], count + 1});

                                continue outer;

                        }
                    }
                    // 뱀인지?
                    for(int[] snk : snake) {
                        if(snk[0] == next_position) {
                                visited[snk[0]] = count + 1;
                                visited[snk[1]] = count + 1;
                                queue.add(new int[] {snk[1], count + 1});

                                continue outer;

                        }
                    }


                    visited[next_position] = count + 1;
                    queue.add(new int[] {next_position, count + 1});
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[101];
        ladder = new int[N][2];
        snake = new int[M][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            // ladder = start < end;
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ladder[i][0] = start; ladder[i][1] = end;
        }

        for(int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());

            // snake = start > end;
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            snake[j][0] = start; snake[j][1] = end;
        }

        // Simulation
        bfs();

        System.out.println(Arrays.toString(visited));

        System.out.println(result);
    }
}
