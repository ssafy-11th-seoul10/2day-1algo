class PG_시소짝꿍_240622 {
    public long solution(int[] weights) {
        //거리의 곱 count를 저장할 list설정 (최대 1000*4 = 4000)
        //같은 숫자 중복을 피하기 위해 숫자 count 배열 설정(하나의 거리에서만 더하고 나머지는 빼준다)
        int[] list = new int[4001];
        int[] count = new int[1001];
        for (int i = 0; i < weights.length; i++) {
            count[weights[i]]++;
            for (int j = 2; j <5 ; j++) {
                list[weights[i]*j]++;
            }
        }

        long answer = 0;
        for (int now : list) {
            if(now>1) answer+=(long)now * (now-1) / 2;
        }
        for (int now : count) {
            if(now>1) answer -= (long) now *(now-1)/2*2;
        }
        return answer;
    }
}