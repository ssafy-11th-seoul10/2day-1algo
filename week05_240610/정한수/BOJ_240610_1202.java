import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BOJ1202 {

    /**
     * 보석을 무게순으로 정렬하고 무거운 무게부터 가방에 넣을 수 있을만큼 전부 담음
     * 담은 가방은 우선순위큐(무게 작은순)에 담아둠
     * 만약 보석을 담을 수 있는 가방이 없는 경우(가방의 무게가 더 작거나, 가방이 부족한 경우) -> 이미 담아둔 가방이 있다면 가장 적은 비용의 보석이 들어간 가방과 비교 후 바꿔주기
     */

    private static class Jewel implements Comparable<Jewel>{
        int M;
        int V;

        public Jewel(int m, int v) {
            M = m;
            V = v;
        }

        public int compareTo(Jewel j){
            return j.M - this.M;
        }
    }

    private static class Bag{
        int C;
        int cost; //들어있는 보석의 가격

        public Bag(int c, int cost) {
            C = c;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> jLst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jLst.add(new Jewel(M,V));
        }

        PriorityQueue<Bag> bPQ = new PriorityQueue<>((o1, o2) -> o2.C-o1.C);
        for (int i = 0; i < K; i++) {
            bPQ.add(new Bag(Integer.parseInt(br.readLine()),0));
        }
        Collections.sort(jLst);

        PriorityQueue<Bag> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);

        for (Jewel j : jLst) {
            //더 이상 넣을 가방이 없는 경우
            if(bPQ.isEmpty()){
                Bag b = pq.poll();
                if(j.V>b.cost){
                    pq.add(new Bag(b.C,j.V));
                }else{
                    pq.add(b);
                }
            }
            else {
                Bag currBag = bPQ.poll();
                //가방에 담을 수 없는 경우 (보석이 무게가 더 큰 경우)
                if(j.M>currBag.C){
                    //이미 담은 가방과도 비교
                    if(!pq.isEmpty()) {
                        Bag b = pq.poll();
                        if (j.V > b.cost) {
                            pq.add(new Bag(b.C, j.V));
                        } else {
                            pq.add(b);
                        }
                    }
                    bPQ.add(currBag);
                    continue;
                }
                //그냥 담을 수 있을 때
                pq.add(new Bag(currBag.C,j.V));
            }
        }
        long answer = 0;
        for(Bag b : pq){
            answer+=b.cost;
        }
        System.out.println(answer);
    }

}
