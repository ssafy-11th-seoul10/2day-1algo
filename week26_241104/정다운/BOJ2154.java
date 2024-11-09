import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ2154 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= N; i++)
            queue.add(i);

        while (!queue.isEmpty()) {

            int throwAway = queue.poll();
            if(queue.isEmpty()) {
                System.out.println(throwAway);
                break;
            }

            int moveToBottom = queue.poll();
            queue.add(moveToBottom);
        }
    }
}
