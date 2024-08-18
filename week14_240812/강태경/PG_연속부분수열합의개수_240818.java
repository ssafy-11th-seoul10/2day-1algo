import java.util.*;

class PG_연속부분수열합의개수_240818 {
    public int solution(int[] elements) {
        //같은 수열을 뒤에 붙이자
        //최대 수열의 길이를 숫자의 개수로 한정
        //누적합 사용
        List<Integer> list = new ArrayList<>();
        for (int element : elements) {
            list.add(element);
        }

        for (int i = 0; i < elements.length-1; i++) {
            list.add(elements[i]);
        }

        int[] prefix = new int[list.size()+1];
        for (int i = 1; i <= list.size(); i++) {
            prefix[i] = prefix[i-1]+list.get(i-1);
        }

        Set<Integer> set = new TreeSet<>();

        for (int start = 1; start <= list.size(); start++) {
            for (int end = start; end <= list.size(); end++) {
                if(end-start+1>elements.length) break;
                int now = prefix[end] - prefix[start - 1];
                set.add(now);
            }
        }
        return set.size();
    }
}