import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static class Top{
        int index;
        int value;

        public Top(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Top[] top = new Top[N];
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            top[i] = new Top(i, Integer.parseInt(st.nextToken()));
        }
        Deque<Top> deque = new ArrayDeque<>();
        for (int i = N-1; i >=0; i--) {
            while(!deque.isEmpty() && deque.peek().value<top[i].value){
                Top t = deque.pollFirst();
                answer[t.index] = top[i].index+1;
            }
            deque.addFirst(top[i]);
        }
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

}