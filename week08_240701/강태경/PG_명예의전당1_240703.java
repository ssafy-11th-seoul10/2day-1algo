import java.util.*;

class PG_명예의전당1_240703 {
    public int[] solution(int k, int[] score) {
        int day = score.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] answer = new int[day];
        for (int i = 0; i < day; i++) {
            if(pq.size()<k){
                pq.add(score[i]);
            } else{
                if(pq.peek()<score[i]){
                    pq.remove();
                    pq.add(score[i]);
                }
            }
            answer[i] = pq.peek();
        }

        return answer;
    }
}