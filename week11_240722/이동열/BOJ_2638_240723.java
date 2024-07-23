package boj;
import java.util.*;
import java.io.*;
/**
 * 네 변중 2변 이상 외부
 * 외벽:-1 내벽: 0 그냥 치즈: 1
 * 외벽이면 BFS 돌려서 외벽 찾기
 * 1. BFS로 외벽 탐색
 * 2. 배열 전체 보면서 없어질 치즈 기록
 * 3. 치즈 없애고 라운드 반복.
 * 4. 종료조건은 2번에서 치즈가 없을 때.
 */
public class BOJ2638 {

    private static int N,M;
    private static int[][] arr;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static Deque<int[]> deque = new ArrayDeque<>();

    //외벽을 찾기 위해 치즈가 없어질 때 마다 deque에 값 넣어주기
    private static void BFS(){
        while (!deque.isEmpty()){
            int[] curr = deque.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny]==0){
                    arr[nx][ny] = -1;
                    deque.add(new int[]{nx,ny});
                }
            }
        }
    }

    //외벽과 마주한 개수 구해주기
    private static int check(int x, int y){
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(arr[nx][ny] == -1){
                cnt+=1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        deque.add(new int[]{0,0});
        deque.add(new int[]{N,M});
        arr[0][0] = -1;
        arr[N-1][M-1] = -1;
        int answer = 0;
        while (!deque.isEmpty()) {
            int cnt = 0;
            boolean[][] remove = new boolean[N][M]; //이번 라운드에 제거해야할 치즈 (기록해놓고 한 번에 처리해야한다
            BFS();  //외벽 찾기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] == 1 && check(i,j)>=2){
                        remove[i][j] = true;
                        deque.add(new int[]{i, j});
                        cnt+=1;
                    }
                }
            }
            if(cnt>0){
                answer+=1;
            }else{ //만약 이번 라운드에 제거할 치즈가 없다면 끝
                break;
            }
            //치즈 제거
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(remove[i][j]){
                        arr[i][j] = -1;
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
