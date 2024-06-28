import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1347 {

    static int N;
    static String command;

    static char[][] board;

    static int x, y;
    static int dir;

    static int[] dx = {-1,0,1,0};
    static int[] dy= {0,1,0,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        command = br.readLine();

        board = new char[101][101];

        for(int i = 0; i < 101; i++)
            for(int j = 0; j < 101; j++)
                board[i][j] = '#';

        x = 50; y = 50; dir = 2;
        board[x][y] = '.';

        for(int l = 0; l < command.length(); l++) {
            char c = command.charAt(l);

            if(c == 'F') {
                x += dx[dir];
                y += dy[dir];

                board[x][y] = '.';
            }
            else if(c == 'L') {
                if(dir - 1 != -1)
                    dir--;
                else
                    dir = 3;
            }
            else {
                if(dir + 1 != 4)
                    dir++;
                else
                    dir = 0;
            }
        }

        // STEP 2. "." minx & miny && maxX & maxY get
        int minX = -1; int minY = -1;
        int maxX = 0; int maxY = 0;

        for(int i = 0; i < 101; i++) {

            boolean isContinue = true;

            for (char t : board[i])
                if (t != '#') {
                    isContinue = false;
                    break;
                }

            if(!isContinue) {
                if(minX == -1)
                    minX = i;
                maxX = i;
            }
        }

        for(int j = 0; j < 101; j++) {

            boolean isContinue = true;

            for(int i = 0; i < 101; i++)
                if(board[i][j] != '#') {
                    isContinue = false;
                    break;
                }

            if(!isContinue) {
                if(minY == -1)
                    minY = j;
                maxY = j;
            }
        }

        // STEP 3. 출력하기
        //System.out.println(minX + " : " + minY);
        //System.out.println(maxX + " : " + maxY);

        StringBuilder sb = new StringBuilder();
        for(int i = minX; i < maxX + 1; i++) {
            for(int j = minY; j < maxY + 1; j++)
                sb.append(board[i][j]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
