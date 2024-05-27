class PG_광물캐기_240527 {

    static void perm(int depth) {
        if (depth == last) {
            answer = Math.min(answer, buf);
            return;
        }
        for (int i = 0; i <3 ; i++) {
            if(picks[i]>0){
                picks[i]--;
                int prev = now;
                int prevBuf = buf;
                for (int j = 0; j <5; j++) {
                    if(now==minerals.length){
                        break;
                    }
                    String mineral = minerals[now++];
                    if (mineral.equals("diamond")) {
                        if(i==0){
                            buf+=1;
                        }else if(i==1){
                            buf+=5;
                        }else{
                            buf+=25;
                        }
                    } else if (mineral.equals("iron")) {
                        if(i==0){
                            buf+=1;
                        }else if(i==1){
                            buf+=1;
                        }else{
                            buf+=5;
                        }
                    }else{
                        if(i==0){
                            buf+=1;
                        }else if(i==1){
                            buf+=1;
                        }else{
                            buf+=1;
                        }
                    }
                }
                perm(depth+1);
                picks[i]++;
                now = prev;
                buf = prevBuf;
            }
        }
    }

    static int answer, last, buf, now;
    static int[] picks;
    static String[] minerals;

    public int solution(int[] picks2, String[] minerals2) {
        picks = picks2;
        minerals = minerals2;
        int picker = 0;
        for (int pick : picks) {
            picker += pick;
        }
        last = Math.min((minerals.length-1)/5+1, picker);
        answer = Integer.MAX_VALUE;
        buf = 0;
        now = 0;
        perm(0);
        return answer;
    }
}