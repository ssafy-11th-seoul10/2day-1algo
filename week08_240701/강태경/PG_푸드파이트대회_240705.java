class PG_푸드파이트대회_240705 {
    public String solution(int[] food) {
        //2로 나눈 몫을 사용

        StringBuilder sb = new StringBuilder();
        String answer = "";
        for (int i = 1; i < food.length; i++) {
            int count = food[i]/2;
            while(count-->0){
                sb.append(i);
            }
        }
        sb.append(0);
        for (int i = food.length-1; i >= 1; i--) {
            int count = food[i]/2;
            while(count-->0){
                sb.append(i);
            }
        }
        answer = sb.toString();
        return answer;
    }
}