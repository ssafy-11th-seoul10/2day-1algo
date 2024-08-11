import java.util.*;

class PG_택배상자_240811 {
    public int solution(int[] order) {
        int len = order.length;
        Deque<Integer> main = new ArrayDeque<>();
        Deque<Integer> sub = new ArrayDeque<>();
        for (int i = 1; i < len+1; i++) {
            main.addFirst(i);
        }
        int count = 0;
        int idx = 0;
        while(true){
            //모두 꺼냈을 경우 탈출
            if(idx==len) break;
            int goal = order[idx];
            int mainBox = -1;
            if(!main.isEmpty()) mainBox = main.peekLast();
            if(goal==mainBox){
                main.removeLast();
                count++;
                idx++;
            } else{
                if(sub.isEmpty()){
                    sub.add(mainBox);
                } else{
                    int subBox = sub.peekLast();
                    if(goal==subBox){
                        count++;
                        idx++;
                        sub.removeLast();
                    } else{
                        //다음 박스가 없을 시 탈출
                        if(main.isEmpty()) break;
                        main.removeLast();
                        sub.add(mainBox);
                    }
                }
            }
        }
        return count;
    }
}