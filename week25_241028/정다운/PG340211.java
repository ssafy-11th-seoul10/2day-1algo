package programmers;
// https://houcouonchi.tistory.com/55
// Map을 써야 9초 정도로 걸리는 걸 줄인다..!
import java.util.*;

class PG340211 {

    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy=  {0,0,1,-1};

    static List<int[]>[] robotPos;

    public static boolean inRange(int x, int y) {
        return (1 <= x && x <= 100) && (1 <= y && y <= 100);
    }

    public static List<int[]> bfs(int[] start, int[] end) {

        visited = new boolean[101][101];
        Queue<List<int[]>> queue = new ArrayDeque<>();

        visited[start[0]][start[1]] = true;
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {start[0], start[1]});
        queue.add(list);

        while(!queue.isEmpty()) {

            List<int[]> curRoutes = queue.poll();

            int[] curPos = curRoutes.get(curRoutes.size() - 1);

            if(curPos[0] == end[0] && curPos[1] == end[1])
                return curRoutes;

            for(int i = 0; i < 4; i++) {

                int nx = curPos[0] + dx[i];
                int ny = curPos[1] + dy[i];

                if(!inRange(nx, ny))
                    continue;

                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;

                    List<int[]> newRoute = new ArrayList<>(curRoutes);
                    newRoute.add(new int[] {nx, ny});
                    queue.add(newRoute);
                }
            }
        }

        return new ArrayList<>();
    }

    public int solution(int[][] points, int[][] routes) {

        robotPos = new List[routes.length];

        for(int i = 0; i < routes.length; i++){

            robotPos[i] = new ArrayList<>();

            for(int j = 0; j < routes[i].length - 1; j++) {

                if(j != 0)
                    robotPos[i].remove(robotPos[i].size() - 1);

                int startPoint = routes[i][j];
                int[] startPos = points[startPoint - 1];


                int endPoint = routes[i][j + 1];
                int[] endPos = points[endPoint - 1];

                robotPos[i].addAll(bfs(startPos, endPos));
            }
        }

        // Simulation
        int maxLeng = 0; int cnt = 0;
        for(List<int[]> li : robotPos)
            maxLeng = Math.max(maxLeng, li.size());

        for(int i = 0; i < maxLeng; i++) {

            int[][] board = new int[101][101];

            for(List<int[]> route : robotPos) {
                if(i >= route.size())
                    continue;

                int[] curPos = route.get(i);
                board[curPos[0]][curPos[1]]++;
            }

            for(int x = 1; x < 101; x++)
                for(int y = 1; y < 101; y++)
                    if(board[x][y] >= 2)
                        cnt++;
        }

        return cnt;

    }
}