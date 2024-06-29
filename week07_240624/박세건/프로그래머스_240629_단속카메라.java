import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes,(x,y)->{
            if(x[0]==y[0]){
                return x[1]-y[1];
            }
            return x[0]-y[0];
        });
        int start=routes[0][0];
        int end=routes[0][1];
        int answer=1;
        for(int i=0;i<routes.length;i++){
            //다음 차량이 겹치지 않을 경우
            if(routes[i][0]>end){
                answer++;
                start=routes[i][0];
                end=routes[i][1];
            }
            //다음 차량이 현재 범위에 속한 경우
            else if(routes[i][1]<end){
                end=routes[i][1];
            }
        }
        return answer;
    }
}
