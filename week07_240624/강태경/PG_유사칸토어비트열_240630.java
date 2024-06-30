class PG_유사칸토어비트열_240630 {
    public int solution(int n, long l, long r) {
        //가운데의 0은 3번째 위치를 무한히 5를 곱한 위치임
        //인덱스 0부터 시작 가정(나머지 연산 편의성)
        // ->5로 무한히 나누었을 때 %5가 2이 되어야함.
        //11011에서 0은 5*n+3위치임 -> %5==2가 되어야함


        int answer = 0;
        for (long i = l-1; i < r; i++) {
            long buf = i;
            while(true){
                if(buf%5==2){
                    break;
                }
                if(buf<5) {
                    answer++;
                    break;
                }
                buf/=5;
            }
        }
        return answer;
    }
}