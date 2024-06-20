package Softeer;

import java.io.*;
import java.util.*;

public class average_grade {

    static int N, K;
    static int[] grades;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grades = new int[N];
        int[] sum_grades = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            grades[i] = Integer.parseInt(st.nextToken());

            if(i == 0)
                sum_grades[i] = grades[i];
            else
                sum_grades[i] = grades[i] + sum_grades[i-1];
        }


        for(int j = 0; j < K; j++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 사람이 몇 명인지?
            int count = end - start + 1;
            // 구간합 유형 -> 구간합 배열 통해 구간합 구하기
            int sum = sum_grades[end - 1];
            if(start != 1)
                sum -= sum_grades[start - 2];

            double res = (double) sum / count;
            // 유형에 맞게 출력 -> 소수점 버려서 출력!
            System.out.printf("%.2f%n", res);
        }

    }
}
