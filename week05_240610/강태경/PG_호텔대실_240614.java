import java.util.*;

class PG_호텔대실_240614 {

    static class Pair{
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solution(String[][] book_time) {
        int count = 1;
        PriorityQueue<Pair> waitQ = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Pair> processQ = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.end - o2.end;
            }
        });
        for (String[] time : book_time) {
            StringTokenizer stk = new StringTokenizer(time[0], ":");
            int hour = Integer.parseInt(stk.nextToken());
            int minute = Integer.parseInt(stk.nextToken());
            int start = hour * 60 + minute;
            stk = new StringTokenizer(time[1], ":");
            hour = Integer.parseInt(stk.nextToken());
            minute = Integer.parseInt(stk.nextToken());
            int end = hour * 60 + minute+10;
            waitQ.add(new Pair(start, end));
        }
        processQ.add(waitQ.remove());
        while (!waitQ.isEmpty()) {
            if(processQ.isEmpty()){
                processQ.add(waitQ.remove());
                continue;
            }
            Pair now = waitQ.remove();
            Pair prev = processQ.peek();
            while(prev.end<=now.start){
                processQ.remove();
                if(processQ.isEmpty()) break;
                prev = processQ.peek();
            }
            if(processQ.size()==count){
                count++;

            }
            processQ.add(now);
        }
        return count;
    }
}