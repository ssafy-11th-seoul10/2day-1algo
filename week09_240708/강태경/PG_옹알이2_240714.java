class PG_옹알이2_240714 {
    public int solution(String[] babbling) {
        //1. 사용 가능한 발음인지
        //2. 연속해서 발음 X
        int answer = 0;
        for (String s : babbling) {
            s = s.replaceAll("aya", "1");
            s = s.replaceAll("ye", "2");
            s = s.replaceAll("woo", "3");
            s = s.replaceAll("ma", "4");
            char prev = s.charAt(0);
            if(prev-'0'<1||prev-'0'>4) continue;
            boolean possible = true;
            for (int i = 1; i < s.length(); i++) {
                char now = s.charAt(i);
                if(now-'0'<1||now-'0'>4||prev==now) {
                    possible = false;
                    break;
                }
                prev = now;
            }
            if(possible) answer++;
        }
        return answer;
    }
}