import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2342_240718 {
    public static void main(String[] args) throws IOException {

        //중앙 -> 다른 모든 곳 : 2
        //인접한 위치로 : 3 (차이가 2일 때)
        //반대편으로 : 4 (차이가 2가 아닐 때)
        //같은 위치 한 번 더 : 1
        //DP -> 턴, 왼쪽 위치, 오른쪽 위치
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while(true){
            int now = Integer.parseInt(stk.nextToken());
            if(now==0) break;
            list.add(now);
        }
        int[][][] d = new int[list.size()][5][5];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    d[i][j][k]=1000000;
                }
            }
        }

        //첫 번째 이동 초기화
        d[0][0][list.get(0)] = 2;
        d[0][list.get(0)][0] = 2;
        for (int i = 1; i < list.size(); i++) {
            int now = list.get(i);
            int prev = list.get(i - 1);
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    //같은 위치에 있을 경우 통과
                    if(now==k || j==k) continue;
                    //이전 발판이 없을 경우 통과
                    if(j!=prev && k!= prev) continue;
                    //반대 방향으로 이동
                    if(j==0){
                        d[i][now][k] = Math.min(d[i][now][k], d[i-1][j][k]+2);
                        d[i][k][now] = Math.min(d[i][k][now], d[i-1][k][j]+2);
                        //같은 발판
                    } else if(now==j){
                        d[i][now][k] = Math.min(d[i][now][k], d[i-1][j][k]+1);
                        d[i][k][now] = Math.min(d[i][k][now], d[i-1][k][j]+1);
                        //0에서 이동
                    } else if(Math.abs(now-j)==2){
                        d[i][now][k] = Math.min(d[i][now][k], d[i-1][j][k]+4);
                        d[i][k][now] = Math.min(d[i][k][now], d[i-1][k][j]+4);
                        //인접한 곳 이동
                    } else{
                        d[i][now][k] = Math.min(d[i][now][k], d[i-1][j][k]+3);
                        d[i][k][now] = Math.min(d[i][k][now], d[i-1][k][j]+3);
                    }
                }

            }
        }
        int answer = 1000000;
        int last = list.get(list.size() - 1);
        for (int i = 0; i < 5; i++) {
            if(i==last) continue;
            answer = Math.min(answer, d[list.size()-1][last][i]);
            answer = Math.min(answer, d[list.size()-1][i][last]);
        }
        System.out.println(answer);

    }
}
