class PG_점찍기_240702 {
    public long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i++) {
            if(i%k==0){
                int maxY = (int)Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
                answer+=maxY/k + 1;
            }
        }
        return answer;
    }
}