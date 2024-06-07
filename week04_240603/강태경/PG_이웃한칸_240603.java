public class PG_이웃한칸_240603 {

    static int solution(String[][] board, int h, int w) {
        int count = 0;
        String now = board[h][w];
        for (int i = 0; i < 4; i++) {
            int nx = h+dx[i];
            int ny = w+dy[i];
            if(nx<0||ny<0||nx>=n||ny>=n||!board[nx][ny].equals(now)) continue;
            count++;
        }
        return count;
    }

    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;
        n = board.length;
        System.out.println(solution(board, h, w));
    }
}