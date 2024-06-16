import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int N = scoville.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            pq.add(scoville[i]);
        }

        while(true){
            if(pq.isEmpty()){
                return -1;
            }
            int a = pq.poll();
            if(pq.isEmpty()){
                if(a < K){
                    return -1;
                }
                break;
            }
            int b = pq.poll();

            if(a >= K){
                break;
            }
            answer++;

            int temp = a + b*2;
            pq.add(temp);
        }

        return answer;
    }
}