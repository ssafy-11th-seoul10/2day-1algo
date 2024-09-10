package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ1758 {

    static int N;
    static int[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        people = new int[N];

        for(int i = 0; i < N; i++)
            people[i] = Integer.parseInt(br.readLine());

        Arrays.sort(people);

        long result = 0; int cnt = 1;

        for(int i = N - 1; i > -1; i--) {
            int tip = people[i] - (cnt - 1);

            if(tip < 0)
                break;

            result += tip;

            cnt++;
        }

        System.out.println(result);
    }
}
