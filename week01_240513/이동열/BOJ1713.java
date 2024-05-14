import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[][] photo = new int[101][2];

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int curr = Integer.parseInt(st.nextToken());
            //사진이 이미 있을 때(가장 먼저 처리해줘야한다..!)
            if(photo[curr][0]!=0){
                photo[curr][0] +=1;
                continue;
            }
            //공간 있을 때
            if(cnt<N){
                photo[curr] = new int[] {1,i};
                cnt++;
                continue;
            }
            //쳐내야할때
            int min=10000;
            int turn = 0;
            int idx = 0;
            for (int j = 0; j < 101; j++) {
                if(photo[j][0]!=0){
                    if(photo[j][0]==min){
                        if(photo[j][1]<turn){
                            turn = photo[j][1];
                            idx = j;
                        }
                    }else if(photo[j][0]<min){
                        min = photo[j][0];
                        turn = photo[j][1];
                        idx = j;
                    }
                }
            }
            photo[idx][0] = 0;
            photo[idx][1] = 0;
            photo[curr][0] = 1;
            photo[curr][1] = i;
        }
        for (int i = 0; i < 101; i++) {
            if(photo[i][0]!=0){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

}
