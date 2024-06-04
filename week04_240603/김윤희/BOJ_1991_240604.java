import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991 {

    static int[][] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'A';
            int b = st.nextToken().charAt(0) - 'A';
            int c = st.nextToken().charAt(0) - 'A';
            tree[a][0] = b;
            tree[a][1] = c;
        }

        before(0);
        sb.append("\n");
        now(0);
        sb.append("\n");
        after(0);

        System.out.println(sb);
    }

    static void before(int a) {
        sb.append((char)(a + 'A'));
        if (tree[a][0] >= 0){
            before(tree[a][0]);
        }
        if (tree[a][1] >= 0){
            before(tree[a][1]);
        }
    }

    static void now(int a) {
        if (tree[a][0] >= 0){
            now(tree[a][0]);
        }
        sb.append((char)(a + 'A'));
        if (tree[a][1] >= 0){
            now(tree[a][1]);
        }
    }

    static void after(int a) {
        if (tree[a][0] >= 0){
            after(tree[a][0]);
        }
        if (tree[a][1] >= 0){
            after(tree[a][1]);
        }
        sb.append((char)(a + 'A'));
    }
}
