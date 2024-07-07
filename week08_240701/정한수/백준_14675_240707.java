import java.io.*;

public class Main {

    private static int readInt() throws IOException {
        int c, n = 0;

        while((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        int N = readInt();
        int[] isLeaf = new int[N + 1];

        for (int i = 1; i < N; i++) {
            int a = readInt(), b = readInt();
            isLeaf[a]++;
            isLeaf[b]++;
        }

        int q = readInt();
        for (int i = 0; i < q; i++) {
            int t = readInt(), k = readInt();

            if (t == 1){
                sb.append(isLeaf[k] > 1 ? "yes\n" : "no\n");
            } else {
                sb.append("yes\n");
            }
        }

        System.out.print(sb);
    }
    
}
