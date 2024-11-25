import java.io.*;
import java.util.*;

/** flattenPos
        - flag    : 벽을 한번 부쉈으면 음수, 아니라면 양수
        - 12~15자리: 행 번호
        - 8~11자리 : 열 번호
        - 1~7자리  : 거리
 */
public class Main {

    private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int[][] field;
    private static int[][][] dists; // [i][j][벽을 파괴했는지 ? 1 : 0]
    private static int N, M;

    private static int getRow(long flattenPos){
        return (int) (Math.abs(flattenPos) / 10000000L / 10000L);
    }

    private static int getCol(long flattenPos){
        return (int) (Math.abs(flattenPos) / 10000000L % 10000L);
    }

    private static int getDist(long flattenPos){
        return (int) (Math.abs(flattenPos) % 10000000L);
    }

    private static boolean hasCrashed(long flattenPos){
        return flattenPos < 0;
    }

    private static long toFlattenPos(int i, int j, int dist, boolean hasCrashed){
        return (i * 10000000L * 10000L + j * 10000000L + dist) * (hasCrashed ? -1 : 1);
    }

    private static boolean isWall(int i, int j){
        return field[i][j] == 1;
    }

    private static boolean isAvailable(int i, int j, int dist, boolean hasCrashed){
        int c = hasCrashed ? 1 : 0;
        return i >= 0 && i < N && j >= 0 && j < M &&
                (field[i][j] == 0 || !hasCrashed) &&
                (dists[i][j][c] == 0 || Math.abs(dists[i][j][c]) > dist);
    }
    
    private static int bfs(){
        if (N == 1 && M == 1){
            return 1;
        }
        Queue<Long> q = new ArrayDeque<>();

        q.add(toFlattenPos(0, 0, dists[0][0][0], false));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0){
                long pos = q.remove();
                int i = getRow(pos), j = getCol(pos), dist = getDist(pos);
                boolean hasCrashed = hasCrashed(pos);

                for (int[] d : D) {
                    int nextI = i + d[0], nextJ = j + d[1], nextDist = dist + 1;
                    boolean nextHasCrashed = hasCrashed;

                    if (!isAvailable(nextI, nextJ, nextDist, hasCrashed)){
                        continue;
                    }

                    if (nextI == N - 1 && nextJ == M - 1){
                        return nextDist;
                    }

                    if (isWall(nextI, nextJ)){
                        if (hasCrashed) {
                            continue;
                        }
                        nextHasCrashed = true;
                    }

                    dists[nextI][nextJ][nextHasCrashed ? 1 : 0] = nextDist * (nextHasCrashed ? -1 : 1);
                    q.add(toFlattenPos(nextI, nextJ, nextDist, nextHasCrashed));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        dists = new int[N][M][2];

        dists[0][0][0] = dists[0][0][1] = 1;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                field[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

}
