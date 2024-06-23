package leetcode;

/** 연속된 n개의 1을 0으로 바꿀 수 있을 때, 최대 값 구하기
 */
class LeetCode1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int N = customers.length;
        int answer = 0;
        for(int i = 0; i<minutes; i++){
            answer+=customers[i];
        }
        for(int i = minutes; i<N; i++){
            if(grumpy[i] == 0){
                answer+=customers[i];
            }
        }
        int cnt = answer;
        int front=1;
        int back=minutes;
        while(back<N){
            if(grumpy[front-1]==1){
                cnt-=customers[front-1];
            }
            if(grumpy[back]==1){
                cnt+=customers[back];
            }
            answer = Math.max(answer,cnt);
            front++;
            back++;
        }
        return answer;
    }
}