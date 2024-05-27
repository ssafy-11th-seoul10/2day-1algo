import java.util.*;
import java.io.*;

class Solution {

    static class Plan implements Comparable<Plan>{
        String name;
        int start;
        int left;

        public Plan(String name, int start, int left){
            this.name = name;
            this.start = start;
            this.left = left;
        }

        @Override
        public int compareTo(Plan o){
            return this.start - o.start;
        }
    }

    static int hourToMinute(String start){
        StringTokenizer stk = new StringTokenizer(start, ":");
        return Integer.parseInt(stk.nextToken())*60 + Integer.parseInt(stk.nextToken());
    }
    public String[] solution(String[][] plans) {
        int len = plans.length;
        String[] answer = new String[len];
        List<Plan> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            list.add(new Plan(plans[i][0], hourToMinute(plans[i][1]), Integer.parseInt(plans[i][2])));
        }
        Collections.sort(list);

        Deque<Plan> q = new ArrayDeque<>();
        int nextIdx = 1;
        int idx = 0;
        q.add(list.get(0));
        while(nextIdx<len){
            Plan now = q.removeLast();
            //다음에 올 plan
            Plan next = list.get(nextIdx);
            //시작해야 할 때가 같을 때 새로 시작하는 것이 우선 순위
            if(now.start==next.start){
                q.add(now);
                q.add(next);
                nextIdx++;
            } else{
                int left = now.start+now.left - next.start;
                //시간이 겹치지 않는다면
                if(left<=0){
                    answer[idx++] = now.name;
                    //멈춘 과제의 시작시간을 현재 과제의 끝낸 시간으로
                    if(!q.isEmpty()){
                        q.peekLast().start = now.start+now.left;
                    }else {
                        //다음 과제 시작
                        q.add(next);
                        nextIdx++;
                    }

                    //시간이 겹친다면 멈춘 대기열에 2개 추가
                }else{
                    q.add(new Plan(now.name, -1, left));
                    q.add(next);
                    nextIdx++;
                }
            }
        }
        while(!q.isEmpty()){
            answer[idx++] = q.removeLast().name;
        }

        return answer;
    }
}