import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_240724_6443 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int ni = 0; ni < n; ni++) {
            String word = br.readLine();
            int k = word.length();
            char[] abcs = new char[k];

            for (int i = 0; i < k; i++) {
                abcs[i] = word.charAt(i);
            }

            Arrays.sort(abcs);

            for (int i = 0; i < k; i++) {
                sb.append(abcs[i]);
            }

            sb.append('\n');

            while (nextPermutation(abcs)) {
                for (int i = 0; i < k; i++) {
                    sb.append(abcs[i]);
                }
    
                sb.append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }

    static boolean nextPermutation(char[] arr) {
        int i = arr.length - 1;

        while (i >= 1 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = arr.length - 1;

        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        char c = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = c;

        j = arr.length - 1;

        while (i < j) {
            c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }

        return true;
    }

}
