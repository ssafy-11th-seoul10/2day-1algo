import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] path = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            path[i][0] = Integer.parseInt(st.nextToken());
            path[i][1] = Integer.parseInt(st.nextToken());
            path[i][2] = Integer.parseInt(st.nextToken());
        }
        int[] dist = new int[d + 1];
        for (int i = 1; i <= d; i++) {
            dist[i] = i;
        }

        for (int i = 0; i <= d; i++) {
            if (i > 0 && dist[i - 1] + 1 < dist[i]) {
                dist[i] = dist[i - 1] + 1;
            }

            for (int j = 0; j < n; j++) {
                // i == 지름길 시작위치 && 지름길 도착위치 <= 전체 길이 && 현재 위치 + 지름길 길이 < 도착 위치까지 길이
                if (i == path[j][0] && path[j][1] <= d && dist[i] + path[j][2] < dist[path[j][1]]) {
                    dist[path[j][1]] = dist[i] + path[j][2];
                }
            }
        }

        System.out.println(dist[d]);
    }
}
