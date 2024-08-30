package baekjoon;

import java.util.*;
import java.io.*;
// https://1-7171771.tistory.com/112

public class BOJ1339 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] data = new String[N];
        int[] table = new int[26];

        for(int i = 0; i < N; i++)
            data[i] = br.readLine();

        for(int col = 0; col < N; col++) {
            int tmp = (int) Math.pow(10, data[col].length() - 1);

            for(int digit = 0; digit < data[col].length(); digit++) {
                table[(int)data[col].charAt(digit) - 65] += tmp;
                tmp /= 10;
            }
        }

        // Greedy
        Arrays.sort(table);
        int number = 9;
        int result = 0;

        for(int i = table.length - 1; i >= 0; i--) {
            if(table[i] == 0)
                break;

            result += table[i] * number;
            number--;
        }
        System.out.println(result);
    }
}
