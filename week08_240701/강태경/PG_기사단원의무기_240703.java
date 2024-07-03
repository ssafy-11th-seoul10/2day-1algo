import java.util.*;

class PG_기사단원의무기_240703 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <=number ; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <=Math.sqrt(i) ; j++) {
                if(i%j==0){
                    list.add(j);
                    if(i/j!=j){
                        list.add(i/j);
                    }
                }
            }
            if(list.size()<=limit){
                answer += list.size();
            } else answer+=power;
        }
        return answer;
    }
}