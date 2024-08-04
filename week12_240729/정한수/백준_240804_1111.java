import java.io.*;
import java.util.*;

public class Main {

    private static String findSuccessor(int[] seq){
        if (seq.length == 1){
            return "A";
        }
        
        if (seq.length == 2 && seq[0] != seq[1]){
            return "A";
        }

        if (seq[0] == seq[1]){
            for (int i = 2; i < seq.length; i++){
                if (seq[i] != seq[i-1]){
                    return "B";
                }
            }
            return String.valueOf(seq[0]);
        }

        if ((seq[1] - seq[2]) % (seq[0] - seq[1]) != 0){
            return "B";
        }

        int a = (seq[1] - seq[2]) / (seq[0] - seq[1]);
        int b = seq[1] - a * seq[0];
        return isCorrect(seq, a, b) ? String.valueOf(seq[seq.length - 1] * a + b) : "B";
    }

    private static boolean isCorrect(int[] seq, int a, int b){
        for (int i = 2; i < seq.length; i++){
            if (seq[i - 1] * a + b != seq[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findSuccessor(seq));
    }
    
}
