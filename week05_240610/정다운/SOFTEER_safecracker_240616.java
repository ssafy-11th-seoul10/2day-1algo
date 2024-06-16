package Softeer;

import java.util.*;
import java.io.*;

public class safecracker {

    static int N, W;
    static int[][] metal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        metal = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int price_per_weight = Integer.parseInt(st.nextToken());

            metal[i][0] = weight; metal[i][1] = price_per_weight;
        }

        // STEP 2.
        // 무게를 톱으로 쪼갤 수 있음 -> 가장 가치가 높은 금속부터 담을 수 있는 만큼 담으면 됨 -> Greedy
        Arrays.sort(metal, (m1, m2) -> m2[1] - m1[1]);

        int result = 0;

        for(int[] M : metal) {
            if(W <= 0)
                break;

            int weight = M[0]; int price = M[1];

            if (W >= weight) {
                W = W - weight;
                result += (weight * price);
            } else {
                result += (W * price);
                W = 0;
            }
        }

        System.out.println(result);
    }

}
