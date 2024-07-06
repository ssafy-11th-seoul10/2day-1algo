package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(gender==1){
                int cnt = num;
                while (cnt <=N) {
                    arr[cnt] = Math.abs(arr[cnt]-1);
                    cnt+=num;
                }
            }
            else if(gender==2){
                arr[num] = Math.abs(arr[num]-1);
                int front = num-1;
                int back = num+1;
                while (front>=1 && back<=N && arr[front]==arr[back]){
                    arr[front] = Math.abs(arr[front]-1);
                    arr[back] = Math.abs(arr[back]-1);
                    front-=1;
                    back+=1;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
            if(i%21==0){
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
