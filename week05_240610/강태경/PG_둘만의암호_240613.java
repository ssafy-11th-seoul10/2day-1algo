import java.util.*;

class PG_둘만의암호_240614 {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new TreeSet<>();
        for (int i = 0; i < skip.length(); i++) {
            set.add(skip.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            int count = index;
            while (count!=0) {
                if(now=='z') now='a'-1;
                now+=1;
                //skip은 건너뛴다.
                if(!set.contains(now)) count--;
            }
            sb.append(now);
        }
        return sb.toString();
    }
}