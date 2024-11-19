package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_241119_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < n; i++) {
            int now = arr[i];
            // 연속 가능하면 넣기
            if (now > list.get(list.size() - 1)) {
                list.add(now);
                //불가능 시 대체 가능한 숫자 찾기
            } else {
                int start = 0;
                int end = list.size()-1;
                int idx = 0;
                while (start <= end) {
                    int mid = (start+end)/2;
                    int num = list.get(mid);
                    if(num<now){
                        start = mid + 1;
                    } else{
                        idx = mid;
                        end = mid - 1;
                    }
                }
                list.set(idx, now);
            }
        }
        System.out.println(list.size());
    }
}
