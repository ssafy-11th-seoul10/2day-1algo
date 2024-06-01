import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5430 {

    static boolean err;
    static int[] arr;
    static boolean flag;
    static int a, b;
    static String[] num;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            char[] func = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                func[i] = str.charAt(i);
            }
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            s = s.substring(1, s.length() - 1);
            num = s.split(",");

            err = false;
            flag = true;
            a = 0;
            b = num.length - 1;
            if (n == 0) b = -1;
            ac(func);
            if (err) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                if (flag) {
                    for (int i = a; i <= b; i++) {
                        sb.append(num[i]);
                        if (i != b) sb.append(",");
                    }
                } else {
                    for (int i = b; i >= a; i--) {
                        sb.append(num[i]);
                        if (i != a) sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }

    static void ac(char[] func){
        for (char c : func) {
            if (c == 'R') {
                flag = !flag;
            }
            else {
                if (a > b || num.length == 0){
                    err = true;
                    return;
                } else {
                    if (flag) {
                        a++;
                    } else {
                        b--;
                    }
                }
            }
        }
    }
}
