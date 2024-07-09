import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240710_27973 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());

        // y = as + b form
        long s = 1;
        long a = 1;
        long b = 0;

        while (q-- > 0) {
            String line = br.readLine();
            long x;

            switch (line.charAt(0)) {
                case '0':
                    x = Long.parseLong(line.substring(2));
                    b += x;
                    break;

                case '1':
                    x = Long.parseLong(line.substring(2));
                    a *= x;
                    b *= x;
                    break;

                case '2':
                    x = Long.parseLong(line.substring(2));
                    s += x;
                    break;

                case '3':
                    sb.append(a * s + b).append("\n");
                    break;
            }
        }

        System.out.print(sb);
        br.close();
    }

}
