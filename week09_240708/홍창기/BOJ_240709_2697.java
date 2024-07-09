import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240709_2697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String num = br.readLine();
            int[] numArr = new int[num.length()];

            for (int i = 0; i < num.length(); i++) {
                numArr[i] = num.charAt(i) - '0';
            }

            if (nextPermutation(numArr)) {
                for (int i = 0; i < numArr.length; i++) {
                    sb.append(numArr[i]);
                }

                sb.append("\n");
            } else {
                sb.append("BIGGEST\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    static boolean nextPermutation(int[] numArr) {
        int i = numArr.length - 1;

        while (i >= 1 && numArr[i - 1] >= numArr[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = numArr.length - 1;

        while (numArr[i - 1] >= numArr[j]) {
            j--;
        }

        int tmp = numArr[i - 1];
        numArr[i - 1] = numArr[j];
        numArr[j] = tmp;

        j = numArr.length - 1;

        while (i < j) {
            tmp = numArr[i];
            numArr[i] = numArr[j];
            numArr[j] = tmp;

            i++;
            j--;
        }

        return true;
    }

}
