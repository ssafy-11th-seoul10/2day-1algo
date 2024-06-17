import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2623 {

    /**
     * 위상정렬 사용
     * 줄 세우기의 관계를 나타내는 List 배열인 edges
     * 나보다 앞에 있어야 하는 사람의 수를 나타내는 countLink
     * edges의 각 index에 담기는 값은 내 뒤에 있는 사람을 담아준다.
     * countLink가 0인 사람부터 앞에 세워주고, 연결되어 있는 사람의 countLink값을 줄여준다. 이 때 0이되면 queue에 넣어줌
     * 줄을 세울 수 없는 경우는 중간에 countLink값이 0이 되는 경우가 없는 경우이다. 개수를 세어주어 예외처리
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] countLink = new int[N+1];
        List<Integer>[] edges = new List[N+1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Integer> lst = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                lst.add(Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j <lst.size(); j++) {
                for (int k = j+1; k<lst.size(); k++) {
                    edges[lst.get(j)].add(lst.get(k));
                    countLink[lst.get(k)]+=1;
                }
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(countLink[i] == 0){
                queue.add(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            sb.append(curr).append("\n");
            index++;
            for(Integer node: edges[curr]){
                countLink[node] -=1;
                if(countLink[node]==0){
                    queue.add(node);
                }
            }
        }
        if(index==N) {
            System.out.println(sb);
        }
        else{
            System.out.println(0);
        }
    }

}
