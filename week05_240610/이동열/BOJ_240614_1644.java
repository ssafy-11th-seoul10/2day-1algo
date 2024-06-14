import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ1644 {

    /**
     * 소수 판정 후 부분합
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[N+1];
        Arrays.fill(prime,true);
        for (int i = 2; (long) i*i <=N; i++) {
            if(prime[i]){
                for (int j = i+i; j <=N; j+=i) {
                    prime[j] = false;
                }
            }
        }
        int index = 0;
        List<Long> sumList = new ArrayList<>();
        sumList.add(Long.valueOf(0));
        for (int i = 2; i <= N; i++) {
            if(prime[i]){
                sumList.add(sumList.get(index) + i);
                index++;
            }
        }

        int p1=0;
        int p2=sumList.size()-1;
        int answer = 0;
        while (p1<p2){
            long sum = sumList.get(p2)-sumList.get(p1);
            if(sum == N){
                answer +=1;
                p2--;
                sum = sumList.get(p2)-sumList.get(p1);
                while(sum<N){
                    if(p1<=0) break;
                    p1--;
                    sum = sumList.get(p2)-sumList.get(p1);
                }
            }else if(sum>N){
                p1++;
            }
            else{
                p2--;
                while(sum<N){
                    if(p1<=0) break;
                    p1--;
                    sum = sumList.get(p2)-sumList.get(p1);
                }
            }
        }
        System.out.println(answer);
    }

}
