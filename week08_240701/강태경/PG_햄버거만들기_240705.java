import java.util.*;

class PG_햄버거만들기_240705 {
    public int solution(int[] ingredient) {
        //1-2-3-1 순서로 들어와야 만들 수 있음
        //큐 사용
        Deque<Integer> q = new ArrayDeque<>();

        int answer = 0;
        for (int now : ingredient) {
            q.add(now);
            while(true){
                if(q.size()>=4&&q.peekLast()==1){
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 4; i++) {
                        sb.append(q.removeLast());
                    }
                    if(sb.toString().equals("1321")){
                        answer++;
                    } else{
                        for (int i = 3; i >= 0; i--) {
                            q.add(sb.charAt(i)-'0');
                        }
                        break;
                    }
                } else break;

            }
        }
        return answer;
    }
}