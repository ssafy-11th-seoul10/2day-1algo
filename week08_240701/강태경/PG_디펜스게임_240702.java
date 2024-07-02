import java.util.*;

class PG_디펜스게임_240702 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }
        );
        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            //적보다 적을 때 무적권을 사용
            if(n<enemy[i]) {
                //무적권 없으면 끝
                if (k == 0) break;
                //현재 적보다 많아지거나 같아질 때까지 무적권을 써야함
                while (n < enemy[i]) {
                    if (k == 0 || pq.isEmpty()) break;
                    n += pq.remove();
                    k--;
                }
                //막기 실패하면 끝
                if (n < enemy[i]) break;
            }
            //막기 성공
            n-=enemy[i];
            answer++;
        }
        return answer;
    }
}