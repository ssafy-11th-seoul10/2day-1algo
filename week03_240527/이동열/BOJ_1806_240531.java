import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        int front = 0;
        int back = 0;
        for (int i = 1; i < N; i++) {
            int curr = Integer.parseInt(st.nextToken());
            if(curr>=S){    //한개로 되는 경우
                System.out.println(1);
                return;
            }
            arr[i] = arr[i-1] + curr;
        }

        //뒤 포인터 찾기
        for (int i = 0; i < N; i++) {
            if(arr[i]>=S){
                back = i;
                break;
            }
        }
        //불가능한 경우
        if(back==0){
            System.out.println(0);
            return;
        }

        int answer = back-front+1;
        int sum = arr[back];
        while(back<N){
            if(sum>=S){
                answer = Math.min(answer,(back-front+1));
                front+=1;
                sum = arr[back] - arr[front-1];
            }
            else{
                back+=1;
                if(back>=N){
                    break;
                }
                if(front>0) {
                    sum = arr[back] - arr[front - 1];
                }
                else{
                    sum = arr[back];
                }
            }
        }
        System.out.println(answer);
    }

}
