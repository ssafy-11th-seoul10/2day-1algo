package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2075 {

    static int N;
    static int[][] board;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer n1, Integer n2) {
            return n2 - n1;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++)
                pq.add(Integer.parseInt(st.nextToken()));
        }

        int res = 0;
        for(int cnt = 0; cnt < N; cnt++)
            if(!pq.isEmpty())
                res = pq.poll();

        System.out.println(res);
    }
}
