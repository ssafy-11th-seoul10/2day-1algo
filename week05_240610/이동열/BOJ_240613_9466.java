import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ9466 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] team = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <=N; i++) {
                team[i] = Integer.parseInt(st.nextToken());
            }

            int[] condition = new int[N+1]; //0: 탐색한적 없음, 1:탐색중, 2:팀 구성 완료
            int[] visited = new int[N+1]; //어느 탐색 시점에 방문했는지 (싸이클 체크 용도)

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 1; i <=N; i++) {
                //이미 탐색을 진행한 경우
                if(condition[i] !=0){
                    continue;
                }
                int curr = i;
                //자기 자신이 팀인경우
                if(team[curr] == curr){
                    condition[curr] = 2;
                    continue;
                }
                //탐색 시작
                condition[curr] = 1;
                visited[curr] = curr;
                deque.add(team[curr]);
                while (!deque.isEmpty()) {
                    int next = deque.poll();
                    //이미 팀이 있는 경우 또는 이번 탐색에서 생긴 싸이클이 아닌 경우
                    if (condition[next] == 2 || (condition[next] == 1 && visited[next] != curr)) {
                        break;
                    }
                    //이번 탐색에서 생긴 싸이클 (팀 처리)
                    if (condition[next] == 1 && visited[next] == curr) {
                        condition[next] = 2;
                        deque.add(team[next]);
                        continue;
                    }
                    //탐색한적이 없는 경우
                    if (condition[next] == 0) {
                        condition[next] = 1;
                        visited[next] = curr; //방문 시점 기록
                        deque.add(team[next]);
                        continue;
                    }
                }
            }
            int answer = 0;
            for (int i = 1; i <=N; i++) {
                if(condition[i]!=2){
                    answer+=1;
                }
            }
            System.out.println(answer);
        }
    }

}
