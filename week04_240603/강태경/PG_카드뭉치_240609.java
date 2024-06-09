import java.util.ArrayDeque;
import java.util.Deque;

public class PG_카드뭉치_240609 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> q1 = new ArrayDeque<>();
        for(String s: cards1){
            q1.add(s);
        }
        Deque<String> q2 = new ArrayDeque<>();
        for(String s: cards2){
            q2.add(s);
        }
        Deque<String> q3 = new ArrayDeque<>();
        for(String s: goal){
            q3.add(s);
        }
        while(!q3.isEmpty()){
            String now = q3.remove();
            if(!q1.isEmpty()){
                String first = q1.peekFirst();
                if(now.equals(first)){
                    q1.remove();
                    continue;
                }
            }
            if(!q2.isEmpty()){
                String second = q2.peekFirst();
                if(now.equals(second)){
                    q2.remove();
                }else{
                    return "No";
                }
            }else return "No";
        }
        return "Yes";
    }
}
