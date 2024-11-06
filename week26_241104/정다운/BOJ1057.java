package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1057 {

    static int Kim, Im;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int round = 1;

        Kim = Integer.parseInt(st.nextToken());
        Im = Integer.parseInt(st.nextToken());

        while (N / 2 != 0) {

            int nextKim = Kim / 2 + Kim % 2;
            int nextIm = Im / 2 + Im % 2;

            if(nextKim == nextIm)
                break;

            Kim = nextKim;
            Im = nextIm;

            round++;
            N = N / 2;
        }

        System.out.println(round);

    }
}
