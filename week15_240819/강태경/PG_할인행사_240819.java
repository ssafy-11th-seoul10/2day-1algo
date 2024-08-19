import java.util.*;

class PG_할인행사_240819 {
    public int solution(String[] want, int[] number, String[] discount) {
        //map을 사용
        Map<String, Integer> map = new TreeMap<>();
        int rest = 10;
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        //초기 10개 값 세팅
        for (int i = 0; i < 10; i++) {
            String now = discount[i];
            if(map.containsKey(now)){
                int count = map.get(now);
                if(count>0){
                    rest--;
                }
                map.put(now, count - 1);
            }
        }
        int answer = 0;

        if(rest==0) answer++;

        //1개씩 빼고 넣으면서 확인
        for (int i = 10; i < discount.length; i++) {
            String prev = discount[i-10];
            if (map.containsKey(prev)) {
                int count = map.get(prev);
                if(count>=0) {
                    rest++;
                }
                map.put(prev, count + 1);
            }
            String next = discount[i];
            if (map.containsKey(next)) {
                int count = map.get(next);
                if(count>0){
                    rest--;
                }
                map.put(next, count - 1);
            }
            if(rest==0) answer++;
        }
        return answer;
    }
}