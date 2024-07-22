package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ18110 {

    static int N;
    static int[] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        students = new int[N];

        for (int i = 0; i < N; i++)
            students[i] = Integer.parseInt(br.readLine());

        //
        int zeolsa_avg = (int) Math.round(N * 0.15);

        Arrays.sort(students);

        int size = N - (2 * zeolsa_avg);
        int res = 0;

        for(int j = zeolsa_avg; j < zeolsa_avg + size; j++)
            res += students[j];

        res = (int) Math.round(1.0 * res / size);
        System.out.println(res);
    }
}
