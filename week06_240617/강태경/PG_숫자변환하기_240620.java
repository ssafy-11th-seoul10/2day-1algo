import java.util.*;

class PG_숫자변환하기_240620 {
    public int solution(int x, int y, int n) {
        if(x==y) return 0;
        int[] d = new int[y+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[x] = 0;
        for (int i = x; i <y ; i++) {
            if(d[i] == Integer.MAX_VALUE) continue;
            if(i+n<=y) d[i+n] = Math.min(d[i+n],d[i] + 1);
            if(i*2<=y) d[i*2] = Math.min(d[i*2], d[i] + 1);
            if(i*3<=y) d[i*3] = Math.min(d[i*3], d[i] + 1);
        }
        if(d[y]==Integer.MAX_VALUE) return -1;
        return d[y];
    }
}