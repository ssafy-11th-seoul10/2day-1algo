import java.util.Collections;
import java.util.PriorityQueue;

public class 프로그래머스_240611_12927 {

  public long solution(int n, int[] works) {
    long answer = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < works.length; i++) {
      pq.add(works[i]);
    }
    int index = 0;
    while (index < n && !pq.isEmpty()) {
      int now = pq.poll();

      now = now - 1;
      if (now > 0)
        pq.add(now);

      index++;
    }

    while (!pq.isEmpty()) {
      int now = pq.poll();

      answer += Math.pow(now, 2);
    }

    return answer;
  }
}
