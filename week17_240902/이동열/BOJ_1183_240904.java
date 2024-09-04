package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * A>B인 경우 약속시간을 미루면 값이 커짐
 * A<B인 경우 약속시간을 미루면 값이 작아짐.
 * 약속시간을 미뤘을 때 값이 커지는 개수와 작아지는 개수가 같을 때 최소 값.
 *
 */
public class BOJ1183 {

    static class Pair implements Comparable<Pair>{
        int x;
        int y;

        @Override
        public int compareTo(Pair o) {
            return (x-y) - (o.x-o.y);
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Pair> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lst.add(new Pair(x,y));
        }
        Collections.sort(lst);
        int answer = 0;
        if(lst.size()%2==1){
            answer = 1;
        }else{
            Pair p1 = lst.get(lst.size()/2-1);
            Pair p2 = lst.get(lst.size()/2);
            answer = Math.abs((p1.x-p1.y) - (p2.x-p2.y))+1;
        }
        System.out.println(answer);
    }

}
