class PG_마법의엘리베이터_240625 {
    public int solution(int storey) {
        //0~4까지는 그대로 사용
        //5일 때는 10의 자리가 5이상이면 10추가 아니면 감소
        //6~9까지는 앞자릿수 올려서 사용
        int answer = 0;
        while(storey!=0){
            int now = storey%10;
            storey/=10;
            if(now<5) answer+=now;
            else if(now==5){
                if(storey% 10>=5){
                    answer+=10-now;
                    storey++;
                } else{
                    answer+=now;
                }
            }
            else {
                answer+=10-now;
                storey++;
            }
        }
        return answer;
    }
}