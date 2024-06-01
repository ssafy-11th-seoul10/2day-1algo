import java.io.*;
import java.util.*;

public class Main {

    private static class Square {

        int r1, r2, c1, c2;

        public Square(int x, int y, int p, int q) {
            this.r1 = y;
            this.r2 = q;
            this.c1 = x;
            this.c2 = p;
        }

        public static char getStatus(Square s1, Square s2){
            char res;

            if (s1.r1 > s2.r2 || s1.r2 < s2.r1 || s1.c1 > s2.c2 || s1.c2 < s2.c1) {
                res = 'd';
            } else if ((s1.r1 == s2.r2 || s1.r2 == s2.r1) && (s1.c1 == s2.c2 || s1.c2 == s2.c1)) {
                res = 'c';
            } else if ((s1.r1 == s2.r2 || s1.r2 == s2.r1) || (s1.c1 == s2.c2 || s1.c2 == s2.c1)) {
                res = 'b';
            } else {
                res = 'a';
            }
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < 4; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Square s1 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Square s2 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(Square.getStatus(s1, s2)).append('\n');
        }
        System.out.println(sb);
    }

}
