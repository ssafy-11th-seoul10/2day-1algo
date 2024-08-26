package PG;

import java.util.ArrayDeque;
import java.util.Deque;

public class PG_거리두기확인하기_240826 {

    static class Pair {
        int x;
        int y;
        int dist;

        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int bfs(Pair start){
        Deque<Pair> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            Pair now = q.remove();
            int x = now.x;
            int y = now.y;
            int dist = now.dist;

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0||ny<0||nx>=5||ny>=5||place[nx].charAt(ny)=='X'||visit[nx][ny]) continue;
                visit[nx][ny] = true;
                if(place[nx].charAt(ny)=='P'){
                    if(dist+1<=2) return 0;
                    q.add(new Pair(nx, ny, 0));
                } else{
                    q.add(new Pair(nx, ny, dist + 1));
                }

            }
        }

        //모두 지키고 있는 경우
        return 1;
    }

    static String[] place;
    static boolean[][] visit;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PPPPP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        //완전 탐색
        //P 응시자
        //O 테이블
        //X 파티션
        //bfs - 사람이면 거리 초기화
        // 파티션이면 더이상 넣지 않음

        int[] result = new int[5];

        for (int i = 0; i < 5; i++) {
            place = places[i].clone();
            int buf = 1;
            for (int j = 0; j <5; j++) {
                for (int k = 0; k < 5; k++) {
                    char now = place[j].charAt(k);
                    if (now == 'P') {
                        visit = new boolean[5][5];
                        visit[j][k] = true;
                        buf = bfs(new Pair(j, k, 0));
                        if(buf == 0){
                            break;
                        }
                    }
                }
                if(buf==0) break;
            }
            result[i] = buf;
        }

        for (int i : result) {
            System.out.println("i = " + i);
        }


    }
}
