package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ8979 {

    static int N, K;
    static int[][] country;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        country = new int[N+1][4];

        for(int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken()); int sliver = Integer.parseInt(st.nextToken()); int bronze = Integer.parseInt(st.nextToken());

            country[i][0] = gold; country[i][1] = sliver; country[i][2] = bronze; country[i][3] = number;
        }

        Arrays.sort(country, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                if(o1[1] == o2[1])
                    return o2[2] - o1[2];
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });

        int res = 0;

        for(int i = 0; i <= N; i++) {

            //System.out.println(country[i][3] + " country : gold : " + country[i][0] + ", sliver : " + country[i][1] + " bronze : " + country[i][2]);

            if(i != 0){
                // 메달 획득이 모두 같은 나라는 같은 등수를 유지한다. ( 단, 다음 나라는 원래 인덱스를 등수로 가진다. )
                if(country[i][0] == country[i-1][0] && country[i][1] == country[i-1][1] && country[i][2] == country[i-1][2]) {
                    if (country[i][3] == K) {
                        System.out.println(res);
                        break;
                    }
                    continue;
                }
            }

            res = (i+1);
            if (country[i][3] == K) {
                System.out.println(res);
                break;
            }
        }
    }
}
