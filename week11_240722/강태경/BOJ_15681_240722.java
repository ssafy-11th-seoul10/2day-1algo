import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15681_240722 {

    static void makeTree(int currentNode, int parent) {
        for (int node : edges.get(currentNode)) {
            if (node != parent) {
                child.get(currentNode).add(node);
                makeTree(node, currentNode);
            }
        }
    }

    static void countSubtreeNodes(int currentNode) {
        size[currentNode] = 1;
        for (int node : child.get(currentNode)) {
            countSubtreeNodes(node);
            size[currentNode] += size[node];
        }
    }

    static List<ArrayList<Integer>> edges;
    static List<ArrayList<Integer>> child;
    static int[] size;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());
        edges = new ArrayList<>();
        child = new ArrayList<>();
        size = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edges.add(new ArrayList<>());
            child.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            stk = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(stk.nextToken());
            int second = Integer.parseInt(stk.nextToken());
            edges.get(first).add(second);
            edges.get(second).add(first);
        }
        makeTree(r, -1);
        countSubtreeNodes(r);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int root = Integer.parseInt(br.readLine());
            sb.append(size[root]).append("\n");
        }

        System.out.println(sb);
    }
}
