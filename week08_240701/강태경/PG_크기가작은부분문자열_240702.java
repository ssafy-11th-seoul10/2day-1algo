class PG_크기가작은부분문자열_240702 {
    public int solution(String t, String p) {
        int tLen = t.length();
        int pLen = p.length();
        long pNum = Long.parseLong(p);
        int result = 0;
        for (int i = 0; i <=tLen-pLen ; i++) {
            long now = Long.parseLong(t.substring(i, i+pLen));
            if(now<=pNum) result++;
        }
        return result;
    }
}