import java.util.*;

class PG_귤고르기_240703 {
    public int solution(int k, int[] tangerine) {
        int num = tangerine.length - k;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int size : tangerine) {
            if(map.containsKey(size)){
                map.put(size, map.get(size)+1);
            } else{
                map.put(size, 1);
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });

        for (Integer key : keySet) {
            int count = map.get(key);
            if(count<=num){
                map.remove(key);
                num-=count;
            } else break;
        }
        int answer = map.size();
        return answer;
    }
}