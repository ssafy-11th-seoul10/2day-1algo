import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_27172_240715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        boolean[] numbers = new boolean[1000001];
        int[] scores = new int[1000001];
        List<Integer> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            players.add(Integer.parseInt(stk.nextToken()));
            numbers[players.get(i)] = true;
        }

        for (int player : players) {
            for (int i = player*2; i < 1000001; i+=player) {
                if(numbers[i]){
                    scores[i]--;
                    scores[player]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer player : players) {
            sb.append(scores[player]).append(" ");
        }
        System.out.println(sb);

    }
}
