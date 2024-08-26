package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ12851 {

    static int[] pos = new int[100001];
    static int[] visited = new int[100001];

    static boolean check(int p) {
        return (0 <= p && p < 100001);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // start
        int K = Integer.parseInt(st.nextToken()); // end

        int minTime = Math.abs(N - K);
        int cnt = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {N, 0});

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int currPos = curr[0]; int currCnt = curr[1];

            if(currPos == K)
                continue;

            // 걷기
            if(check(currPos + 1) && (visited[currPos + 1] == 0 || visited[currPos + 1] >= currCnt + 1)) {
                queue.add(new int[] {currPos + 1, currCnt + 1});

                if(currPos + 1 == K) {
                    if(visited[K] == 0) {
                        minTime = currCnt + 1;
                        visited[K] = currCnt + 1;
                        cnt++;
                    }
                    else if(visited[K] == currCnt + 1)
                        cnt++;
                }
                else
                    visited[currPos + 1] = currCnt + 1;
            }

            if(check(currPos - 1) && (visited[currPos - 1] == 0 || visited[currPos - 1] >= currCnt + 1)) {
                queue.add(new int[] {currPos - 1, currCnt + 1});

                if(currPos - 1 == K) {
                    if(visited[K] == 0) {
                        minTime = currCnt + 1;
                        visited[K] = currCnt + 1;
                        cnt++;
                    }
                    else if(visited[K] == currCnt + 1)
                        cnt++;
                }
                else
                    visited[currPos - 1] = currCnt + 1;
            }

            if(check(currPos * 2) && (visited[currPos * 2] == 0 || visited[currPos * 2] >= currCnt + 1)) {
                queue.add(new int[] {currPos * 2, currCnt + 1});

                if(currPos * 2 == K) {
                    if(visited[K] == 0) {
                        minTime = currCnt + 1;
                        visited[K] = currCnt + 1;
                        cnt++;
                    }
                    else if(visited[K] == currCnt + 1)
                        cnt++;
                }
                else
                    visited[currPos * 2] = currCnt + 1;
            }
        }

        if(N == K) {
            System.out.println(0);
            System.out.println(1);
        }
        else {
            System.out.println(minTime);
            System.out.println(cnt);
        }
    }
}
