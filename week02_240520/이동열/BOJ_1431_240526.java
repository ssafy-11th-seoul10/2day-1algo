import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1431 {

    private static class Node implements Comparable<Node>{
        int sum;
        String str;

        public Node(int sum, String str) {
            this.sum = sum;
            this.str = str;
        }

        @Override
        public int compareTo(Node o) {
            if (this.str.length() != o.str.length()) {
                return this.str.length() - o.str.length();
            }
            else if(this.str.length()==o.str.length() && this.sum!= o.sum){
                return this.sum - o.sum;
            }
            else{
                return this.str.compareTo(o.str);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                int num = s.charAt(j);
                if(49<=num && num<=57){
                    cnt+= num-48;
                }
            }
            Node node = new Node(cnt,s);
            pq.add(node);
        }
        for (int i = 0; i < N; i++) {
            Node node = pq.poll();
            sb.append(node.str).append("\n");
        }
        System.out.println(sb);
    }
}
