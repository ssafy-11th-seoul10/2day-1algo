import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_240606_15721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 0 1 0 1 0 0 1 1 // 4 5 / 6 7
        // 0 1 0 1 0 0 0 1 1 1 // 4 5 6 / 7 8 9
        // 0 1 0 1 0 0 0 0 1 1 1 1// 5 6 7 8/ 9 10 11 12
        // 0 1 0 1 0 0 0 0 0 1 1 1 1 1// 5 6 7 8 9 / 10 11 12 13 14

        int t = Integer.parseInt(br.readLine());
        int sign = Integer.parseInt(br.readLine());

        int index = 0; // 사람 번째
        int count = 0;
        int round = 1; // 회차
        int turn = 0; // 번째

        while (count < t) {
            if (sign == 0) {
                if (turn == 0 || turn == 2 || (4 <= turn && turn <= 4 + round)) {
                    count++;
                }
            } else { // sign == 1
                if (turn == 1 || turn == 3 || 4 + round < turn) {
                    count++;
                }
            }

            // System.out.println("사람 : " + index);
            // System.out.println("턴 : " + turn);
            // System.out.println("라운드 : " + round);
            // System.out.println("카운트 : " + count);

            if (count == t)
                break;

            turn++;
            index++;
            index = (index % n);

            // System.out.println();
            if (turn == 8 + round * 2 - 2) {
                round++;
                turn = 0;
            }
        }

        System.out.println(index);
    }
}
