import java.util.*;

class PG_과일장수_240703 {
    public int solution(int k, int m, int[] score) {
        //내림차순 정렬해서 순서대로 담으면 됨
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
        }
        Collections.sort(list);
        Collections.reverse(list);
        int count = list.size()/m;
        int answer = 0;
        for (int i = 0; i < count; i++) {
            answer+=list.get(i*m+m-1)*m;
        }
        return answer;
    }
}