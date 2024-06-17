import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int N;


    public static void main(String[] args) throws IOException {
        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();
        String[] splitStrings = bufferedReader.readLine().split("");
        leftStack.addAll(Arrays.asList(splitStrings));
        N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            String tmp = bufferedReader.readLine();
            if (tmp.equals("L") && !leftStack.isEmpty()) {
                rightStack.add(leftStack.pop());
            } else if (tmp.equals("D") && !rightStack.isEmpty()) {
                leftStack.add(rightStack.pop());
            } else if (tmp.equals("B") && !leftStack.isEmpty()) {
                leftStack.pop();
            } else if (tmp.charAt(0) == 'P') {
                leftStack.add(tmp.charAt(2) + "");
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (String s : leftStack) {
            bw.write(s);
        }
        while (!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }
        bw.flush();
        bw.close();
    }
}
