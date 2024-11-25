package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_241125_2352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        for (int i = 1; i <n ; i++) {
            int findNum = arr[i];

            int start = 0;
            int end = list.size();

            //Upper Bound
            while (start < end) {
                int mid = (start + end) / 2;
                int now = list.get(mid);

                if(now<=findNum){
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            if(start==list.size()) list.add(findNum);
            else list.set(start, findNum);
        }

        System.out.println(list.size());
    }
}
