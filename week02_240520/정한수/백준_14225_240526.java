import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            Set<Integer> tmp = new HashSet<>();
            int n = Integer.parseInt(st.nextToken());
            tmp.add(n);
            set.forEach((e) -> tmp.add(e + n));
            set.addAll(tmp);
        }

        for (int n = 1; true; n++){
            if (!set.contains(n)){
                System.out.println(n);
                return;
            }
        }

    }

}
