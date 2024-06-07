import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1789 {
    //더하다가 주어진 값보다 더 커지면 마지막 수, 마지막 이전 수 말고 합아 S 되는 수 더해주면 됨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        long S = Long.parseLong(br.readLine());
        long sum = 0;
        long answer = 0;
        for(int i = 1; i<=S; i++){
            sum+=i;
            if(sum>S){
                break;
            }
            else if(sum == S){
                answer++;
                break;
            }
            answer+=1;
        }
        System.out.println(answer);
    }

}
