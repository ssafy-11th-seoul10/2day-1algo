package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ15903 {

    static int N, M;

    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            pq.add(Long.parseLong(st.nextToken()));

        for(int cnt = 0; cnt < M; cnt++) {
            long firstCard = 0;
            if(!pq.isEmpty())
                firstCard = pq.poll();

            long secondCard = 0;
            if(!pq.isEmpty())
                secondCard = pq.poll();


            pq.add(firstCard + secondCard);
            pq.add(firstCard + secondCard);
        }

        long sum = 0;
        Iterator<Long> iter = pq.iterator();
        while(iter.hasNext())
            sum += iter.next();

        System.out.println(sum);
    }
}
