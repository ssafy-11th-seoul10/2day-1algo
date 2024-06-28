class PG_문자열나누기_240627 {
    public int solution(String s) {
        int answer = 0;
        int index = 0;
        while(index!=s.length()){
            char first = s.charAt(index);
            int a = 1;
            int b = 0;
            index++;
            while(index!=s.length()&&a!=b){
                if(s.charAt(index++)==first) a++;
                else b++;
            }
            answer++;
        }
        return answer;
    }
}