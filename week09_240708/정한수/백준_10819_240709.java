import java.io.*;
import java.util.*;

public class Main {

    private static final Deque<Integer> deq = new ArrayDeque<>();
    private static int[] arr;
    private static int max;

    private static void smallCase(int l, int r, int sum){
        if (l > r){
            max = Math.max(max, sum);
            return;
        }
        int tmp;

        tmp = Math.abs(arr[l] - deq.getFirst());
        deq.addFirst(arr[l]);
        bigCase(l + 1, r, sum + tmp);
        deq.removeFirst();
        
        tmp = Math.abs(arr[l] - deq.getLast());
        deq.addLast(arr[l]);
        bigCase(l + 1, r, sum + tmp);
        deq.removeLast();
    }

    private static void bigCase(int l, int r, int sum){
        if (l > r){
            max = Math.max(max, sum);
            return;
        }
        int tmp;

        tmp = Math.abs(arr[r] - deq.getFirst());
        deq.addFirst(arr[r]);
        smallCase(l, r - 1, sum + tmp);
        deq.removeFirst();
        
        tmp = Math.abs(arr[r] - deq.getLast());
        deq.addLast(arr[r]);
        smallCase(l, r - 1, sum + tmp);
        deq.removeLast();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        deq.add(arr[0]);
        deq.add(arr[N - 1]);
        smallCase(1, N - 2, Math.abs(arr[0] - arr[N - 1]));
        System.out.println(max);
    }

}
