import java.util.*;

class PG_혼자놀기의달인_240818 {
    public int solution(int[] cards) {
        boolean[] isOpen = new boolean[cards.length];
        int count = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        //모두 open 될 때까지 반복
        int idx = 0;
        while(count<cards.length){
            int size = 0;
            //다음 open 할 첫 상자 찾기
            for (int i = 0; i < cards.length; i++) {
                if(!isOpen[i]) {
                    idx = i;
                    break;
                }
            }
            //적혀있는 숫자의 상자가 열려있을 때까지 반복
            while(true){
                if(!isOpen[idx]) {
                    isOpen[idx]=true;
                    count++;
                    size++;
                    //편의상 상자의 번호를 0부터
                    idx = cards[idx]-1;
                } else{
                    q.add(size);
                    break;
                }
            }
        }
        if(q.size()>=2){
            return q.remove()*q.remove();
        } else{
            return 0;
        }
    }
}