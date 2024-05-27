import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1431_240527 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }

                int d1 = 0;
                int d2 = 0;

                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) <= '9') {
                        d1 += o1.charAt(i) - '0';
                    }
                }

                for (int i = 0; i < o2.length(); i++) {
                    if (o2.charAt(i) <= '9') {
                        d2 += o2.charAt(i) - '0';
                    }
                }

                if (d1 != d2) {
                    return d1 - d2;
                }

                return o1.compareTo(o2);
            }

        });

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}
