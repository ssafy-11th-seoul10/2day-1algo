import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1806_240718 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int s = Integer.parseInt(stk.nextToken());
        List<Integer> list = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(stk.nextToken()));
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int len = 0;
        int answer = Integer.MAX_VALUE;
        boolean possible = false;
        while(true){
            //합이 목표보다 크거나 같다면 start 증가
            if(sum>=s){
                possible = true;
                answer = Math.min(answer, len);
                sum -= list.get(start);
                start++;
                len--;
            //합이 목표보다 작다면 end 증가
            } else{
                //더이상 증가시킬 수 없다면 종료
                if(end==n) break;
                sum+=list.get(end);
                end++;
                len++;
            }
        }

        if(possible) System.out.println(answer);
        else System.out.println(0);


    }
}
