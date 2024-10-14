import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, K;


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        N *= 2;
        int[] belt = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N / 2 - 1;

        int resultCnt = 0;
        int answer = 0;
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        while (resultCnt < K) {
            answer++;
            /*
             *  벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
             * */
            start--;
            end--;
            if (start < 0)
                start += N;
            if (end < 0)
                end += N;
            /*
             *  가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
             *  만약 이동할 수 없다면 가만히 있는다.
             *  로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
             * */
            int beforeQueueSize = queue.size();
            for (int i = 0; i < beforeQueueSize; i++) {
                /*
                 *   로봇이 내리는 위치일때
                 * */
                int curRobotIdx = queue.poll();
                if (curRobotIdx == end) {
                    visited[curRobotIdx] = false;
                    continue;
                }
                int newRobotIdx = (curRobotIdx + 1) % N;
                if (belt[newRobotIdx] != 0 && !visited[newRobotIdx]) {
                    belt[newRobotIdx]--;
                    if (belt[newRobotIdx] == 0) {
                        resultCnt++;
                    }
                    visited[curRobotIdx] = false;
                    if (newRobotIdx != end) {
                        queue.add(newRobotIdx);
                        visited[newRobotIdx] = true;
                    }
                } else {
                    queue.add(curRobotIdx);
                }
            }
            /*
             *   올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
             * */
            if (belt[start] != 0) {
                queue.add(start);
                visited[start] = true;
                belt[start]--;
                if (belt[start] == 0) {
                    resultCnt++;
                }
            }
        }
        System.out.println(answer);
    }
}
