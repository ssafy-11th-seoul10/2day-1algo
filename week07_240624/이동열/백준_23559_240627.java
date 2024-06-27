package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 다 1000원짜리 먹고 pq에서 빼가면서 가장 큰거 5000원 짜리로 바꿔주기
 */
public class BOJ23559 {

    private static class Pair implements Comparable<Pair>{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return (o.x-o.y)-(x-y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int cnt = 1000*N; //처음에 모두 1000원짜리 먹었다고 생각
        int answer = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Pair(x,y));
            answer += y;
        }
        while (cnt<X && !pq.isEmpty()){
            Pair p = pq.poll();
            if(p.y<p.x){
                cnt+=4000;
                if(cnt>X) break;
                answer+=p.x;
                answer-=p.y;
            }
        }
        System.out.println(answer);
    }
}
