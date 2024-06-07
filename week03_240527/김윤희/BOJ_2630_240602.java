import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {

    static int[][] map;
    static int cntw, cntb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cntw = 0;
        cntb = 0;
        cut(0, 0, N);
        sb.append(cntw).append("\n").append(cntb);
        System.out.println(sb);
    }

    static void cut(int x, int y, int len){
        if (check(x, y, len)){
            if(map[x][y] == 1) cntb++;
            else cntw++;
        } else {
            cut(x, y, len/2);
            cut(x + len/2, y, len/2);
            cut(x, y + len/2, len/2);
            cut(x + len/2, y + len/2, len/2);
        }
    }

    static boolean check(int x, int y, int len){
        int c = map[x][y];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if (map[x + i][y + j] != c){
                    return false;
                }
            }
        }
        return true;
    }
}
