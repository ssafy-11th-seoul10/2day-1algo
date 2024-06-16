package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1244 {

    static int N;
    static int[] switches;

    static int num_std;
    //static int[][] std;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        switches = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++)
            switches[i] = Integer.parseInt(st.nextToken());

        num_std = Integer.parseInt(br.readLine());

        // STEP 2. Logic 수헹
        for(int i = 0; i < num_std; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            // 남자
            if(gender == 1) {
                for(int tmp = number; tmp < N + 1; tmp = tmp + number)
                    switches[tmp] = 1 - switches[tmp];
            }
            // 여자
            else {
                switches[number] = 1 - switches[number];

                int left = number - 1; int right = number + 1;
                // 시작 번호가 1, 그런데 제외 해야 되는 left == 0 과 right = 2 일 경우
                    // 시작 번호가 1, 때문에 번호 2인 스위치면 바뀌면 안되는데, 바뀌는 문제 발생!
                while((left > 0 && right < N + 1)) {
                    if(switches[left] != switches[right])
                        break;

                    switches[left] = 1 - switches[left] ;
                    switches[right] = 1 - switches[right];

                    left--;
                    right++;
                }

            }
        }

        // STEP 3. 출력 ( 20개 씩 )
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {

            sb.append(switches[i]);

            if(i % 20 == 0)
                sb.append("\n");

            else
                sb.append(" ");
        }

        System.out.println(sb);
    }
}
