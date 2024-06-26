package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2573 {
    
    private static int N,M;
    private static int[][] graph;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    
    private static void round(){
        int[][] melt = new int[N][M]; //이번 라운드에 녹는 양
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 0){
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    if (i + dx[k] >= 0 && i + dx[k] < N && j + dy[k] >= 0 && j + dy[k] < M
                        && graph[i + dx[k]][j + dy[k]] == 0) {
                        melt[i][j] += 1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] -= melt[i][j];
                if(graph[i][j]<0) graph[i][j] = 0;
            }
        }
    }

    //덩이 개수 체크
    private static int check() {
        int cnt = 0; // 덩이 수
        boolean[][] visited = new boolean[N][M];
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && graph[i][j]!=0){
                    cnt+=1;
                    if(cnt>=2){
                        return 2;   //분리 완료
                    }
                    deque.add(new int[]{i,j});
                    while (!deque.isEmpty()) {
                        int[] curr = deque.poll();
                        int x = curr[0];
                        int y = curr[1];
                        for (int k = 0; k < 4; k++) {
                            if (x + dx[k] >= 0 && x + dx[k] < N && y + dy[k] >= 0 && y + dy[k] < M
                                && graph[x + dx[k]][y + dy[k]] != 0 && !visited[x+dx[k]][y+dy[k]]) {
                                visited[x+dx[k]][y+dy[k]] = true;
                                deque.add(new int[]{x+dx[k],y+dy[k]});
                            }
                        }
                    }
                }
            }
        }
        if(cnt==0) return 0;    //전부 다 녹을떄 까지 분리 안되는 경우
        return 1; //아직 한덩이인 경우
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true){
            int flag = check();
            if(flag==1){
                round();
                answer++;
                continue;
            }
            if(flag==0){
                System.out.println(0);
                return;
            }
            if(flag==2){
                System.out.println(answer);
                return;
            }
        }
    }

}
