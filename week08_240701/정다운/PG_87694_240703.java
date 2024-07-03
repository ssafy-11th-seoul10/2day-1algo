package programmers;

import java.util.*;

// 내 코드의 문제점 -> 아래에서, 왼쪽과 같이 이동해야 되는데 오른쪽처럼 인식되는 문제, 테두리 인식 반례!
    // →→ →→        →→→
    //  ↓→↑     =>
// 단, 해당 케이스 제외 테두리는 다 인식 가능!

// ※ 테두리 계산 테크닉!
// 테두리를 구분해야만 한다. -> 전통적인 해결법 -> 길이와 좌표를 2배로 늘려서 해당 케이스를 해결
// 2배로 늘려 해당 케이스를 해결하고, 마지막으로 다시 2로 나눠 스케일을 줄여 답을 도출한다.

public class PG87694 {

    static int[][] board = new int[102][102];
    static boolean[][] visited = new boolean[102][102];

    static int[] px = {-1,0,1,0};
    static int[] py = {0,-1,0,1};

    static int[] dx = {-1,-1,-1,0, 1,1,1,0};
    static int[] dy = {-1,0,1,1, 1,0,-1,-1};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < 102) && (0 <= y && y < 102);
    }

    // STEP 1. 사각형 채우기
    public static void addPosition(int[] rect) {

        int x1 = rect[0] * 2; int x2 = rect[2] * 2;
        int y1 = rect[1] * 2; int y2 = rect[3] * 2;

        for(int x = x1; x <= x2; x++)
            for(int y = y1; y <= y2; y++)
                board[x][y]++;
    }

    // STEP 2. 테두리 체크
    public static boolean border_check(int x, int y) {

        int zero_cnt = 0;

        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i]; int ny = y + dy[i];

            if(inRange(nx, ny) && board[nx][ny] == 0)
                zero_cnt++;
        }

        return zero_cnt != 0;
    }

    // STEP 2. BFS
    public static int bfs(int chX, int chY, int itX, int itY) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{chX, chY, 0});
        visited[chX][chY] = true;

        while(!q.isEmpty()) {

            int[] curPos = q.poll();
            int x = curPos[0]; int y = curPos[1]; int cnt = curPos[2];

            if(x == itX && y == itY)
                return cnt;

            for(int i = 0; i < 4; i++) {
                int nx = x + px[i]; int ny = y + py[i];

                if(inRange(nx, ny) && board[nx][ny] != 0 && !visited[nx][ny]) {
                    if(border_check(nx, ny)) {
                        q.add(new int[]{nx, ny, cnt + 1});
                        visited[nx][ny] = true;
                    }

                }
            }
        }

        return -1;
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        for(int[] rect : rectangle) {
            addPosition(rect);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++)
                sb.append(board[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    // Main
    public static void main(String[] args) {

        int[][] rect1 = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};

        int res = solution(rect1, 1,3,7,8);

        System.out.println(res);
    }
}
