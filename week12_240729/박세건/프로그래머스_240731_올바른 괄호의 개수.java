( ) <- 괄호가 새로추가되었을때 괄호의 안과 밖을 나눴을때 만들어질 수 있는 경우를 생각


-----

class Solution {
    public int solution(int n) {
        int[] dp=new int[22];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
