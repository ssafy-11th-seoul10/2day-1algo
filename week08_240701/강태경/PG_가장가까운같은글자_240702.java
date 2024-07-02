import java.util.*;

class PG_가장가까운같은글자_240702 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            int now = s.charAt(i) - 'a';
            if(arr[now]==-1){
                answer[i] = -1;
            } else{
                answer[i] = i - arr[now];
            }
            arr[now] = i;
        }
        return answer;
    }
}