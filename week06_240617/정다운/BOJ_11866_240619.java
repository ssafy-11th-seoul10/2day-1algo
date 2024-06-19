package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ11866 {

    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        int cnt = 1;

        sb = new StringBuilder();
        sb.append("<");

        for(int num = 1; num < N + 1; num++)
            queue.add(num);

        while (!queue.isEmpty()) {
            int curNum = queue.poll();

            if(queue.isEmpty()) {
                sb.append(curNum).append(">");
                break;
            }

            if(cnt == M) {
                sb.append(curNum).append(", ");
                cnt = 1;
            }

            else {
                queue.add(curNum);
                cnt++;
            }

        }

        System.out.println(sb);
    }
}
