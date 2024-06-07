import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int answer = -1;
    public static char[][] map;
    public static boolean[][] answerVisited;
    public static ArrayList<Node> answerNode = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        answerVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*') {
                    int size = 0;
                    for (int k = 1; ; k++) {
                        if (i - k < 0 || i + k >= N || j - k < 0 || j + k >= M) {
                            break;
                        }
                        if (map[i - k][j] == '*' && map[i + k][j] == '*' && map[i][j - k] == '*'
                            && map[i][j + k] == '*') {
                            size = k;
                        } else {
                            break;
                        }
                    }

                    if (size > 0) {
                        answerNode.add(new Node(i + 1, j + 1, size));
                        answerVisited[i][j] = true;
                        for (int k = 1; k <= size; k++) {
                            answerVisited[i + k][j] = true;
                            answerVisited[i - k][j] = true;
                            answerVisited[i][j + k] = true;
                            answerVisited[i][j - k] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*' && !answerVisited[i][j]) {
                    System.out.println(answer);
                }
            }
        }

        System.out.println(answerNode.size());

        for (Node node : answerNode) {
            System.out.println(node.x + " " + node.y + " " + node.s);
        }
    }
}

class Node {
    int x;
    int y;
    int s;

    public Node(int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
}
