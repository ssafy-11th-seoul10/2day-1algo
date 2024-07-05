import java.util.*;

class PG_우박수열정적분_240705 {
    public double[] solution(int k, int[][] ranges) {

        //누적합으로 최적화
        int n = 0;
        List<Double> size = new ArrayList<>();
        size.add(0.0);
        while(k!=1){
            n++;
            //감소
            if(k%2==0) {
                k/=2;
                size.add(size.get(n-1)+k+k/2.0);
            }
            //증가
            else {
                size.add(size.get(n-1)+2.0*k+0.5);
                k = k * 3 + 1;
            }
        }
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end =n+ranges[i][1];
            if(start>end) answer[i] = -1;
            else{
                answer[i] = size.get(end) - size.get(start);
            }
        }
        return answer;
    }
}