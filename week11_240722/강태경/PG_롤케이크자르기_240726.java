import java.util.*;

class PG_롤케이크자르기_240726 {
    public int solution(int[] topping) {
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        int[] count = new int[10001];
        for (int i = 0; i < topping.length; i++) {
            set2.add(topping[i]);
            count[topping[i]]++;
        }

        int idx = 0;
        int answer = 0;
        while (idx < topping.length) {
            if(set1.size()==set2.size()) answer++;
            int now = topping[idx];
            count[now]--;
            if(count[now]==0) set2.remove(now);
            set1.add(now);
            idx++;
        }
        return answer;
    }
}