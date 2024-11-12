package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_241112_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        int start = 1;
        int end = list.get(n-1);
        int answer = 0;
        while(start<=end){
            int mid = (start + end) / 2;
            int cnt = 1;
            //설치한 위치
            int now = 0;
            for (int i = 1; i <n ; i++) {
                if(mid<=list.get(i)-list.get(now)){
                    now = i;
                    cnt++;
                }
            }
            if(cnt<c){
                end = mid-1;
            } else {
                answer = Math.max(answer, mid);
                start = mid+1;
            }
        }
        System.out.println(answer);
    }
}
