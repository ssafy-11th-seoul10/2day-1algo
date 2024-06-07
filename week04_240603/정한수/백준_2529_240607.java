import java.io.*;

public class Main {

    private static char[] max, min;
    private static String s;
    private static int N;

    private static boolean isAvailable(char[] target, int idx){
        return s.charAt(idx * 2 - 2) == '<' ? target[idx - 1] < target[idx] : target[idx - 1] > target[idx];
    }

    private static boolean getMax(int visited, int idx){
        if (idx == N + 1){
            System.out.println(new String(max));
            return true;
        }

        for (int n = 9; n >= 0; n--){
            if ((visited & (1 << n)) == 0){
                max[idx] = (char)(n + '0');
                if ((idx == 0 || isAvailable(max, idx)) && getMax(visited | (1 << n), idx + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean getMin(int visited, int idx){
        if (idx == N + 1){
            System.out.println(new String(min));
            return true;
        }

        for (int n = 0; n <= 9; n++){
            if ((visited & (1 << n)) == 0){
                min[idx] = (char)(n + '0');
                if ((idx == 0 || isAvailable(min, idx)) && getMin(visited | (1 << n), idx + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        s = br.readLine();
        max = new char[N + 1];
        min = new char[N + 1];
        getMax(0, 0);
        getMin(0, 0);
    }

}
