import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int N;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();
            if (command.equals("push")) {
                int x = Integer.parseInt(stringTokenizer.nextToken());
                deque.add(x);
            } else if (command.equals("pop")) {
                if (deque.isEmpty()) {
                    stringBuilder.append(-1).append("\n");


                } else {
                    int x = deque.poll();
                    stringBuilder.append(x).append("\n");
                }
            } else if (command.equals("size")) {
                stringBuilder.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) {
                    stringBuilder.append(1).append("\n");
                } else {
                    stringBuilder.append(0).append("\n");
                }
            } else if (command.equals("front")) {
                if (deque.isEmpty()) {
                    stringBuilder.append(-1).append("\n");

                } else {
                    stringBuilder.append(deque.getFirst()).append("\n");
                }
            } else if (command.equals("back")) {
                if (deque.isEmpty()) {
                    stringBuilder.append(-1).append("\n");

                } else {
                    stringBuilder.append(deque.getLast()).append("\n");
                }
            }
        }
        System.out.println(stringBuilder);
    }
}
