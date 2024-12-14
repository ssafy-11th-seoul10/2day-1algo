import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int answer = 0;
    private static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        List<int[]> pillars = new ArrayList<>();
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(height, maxHeight);
            pillars.add(new int[]{idx, height});
        }
//        System.out.println("maxHeight = " + maxHeight);
        pillars.sort(Comparator.comparingInt(value -> value[0]));

        Stack<int[]> stack = new Stack<>();

        int targetIdx;
        for (targetIdx = 0; targetIdx < pillars.size(); targetIdx++) {
            if (stack.isEmpty()) {
                stack.add(pillars.get(targetIdx));
            } else if (stack.peek()[1] < pillars.get(targetIdx)[1]) {
//                System.out.println(pillars.get(targetIdx)[0] + " " + pillars.get(targetIdx)[1] + " " + maxHeight + " " + stack.peek()[0] + " " + stack.peek()[1]);
                answer += (Math.abs(pillars.get(targetIdx)[0] - stack.peek()[0])) * stack.peek()[1];
//                System.out.println(answer);
                stack.add(pillars.get(targetIdx));
            }
            if (pillars.get(targetIdx)[1] == maxHeight) {
                break;
            }
        }
        stack.clear();
//        System.out.println(targetIdx);
//        System.out.println("------------");
        for (int i = pillars.size() - 1; i >= targetIdx; i--) {
            if (stack.isEmpty()) {
                stack.add(pillars.get(i));
            } else if (stack.peek()[1] <= pillars.get(i)[1]) {
//                System.out.println(pillars.get(i)[0] + " " + pillars.get(i)[1] + " " + maxHeight + " " + stack.peek()[0] + " " + stack.peek()[1]);
                answer += (Math.abs(pillars.get(i)[0] - stack.peek()[0])) * stack.peek()[1];
//                System.out.println(answer);
                stack.add(pillars.get(i));
            }
        }
        answer += stack.peek()[1];
        System.out.println(answer);
    }

}
