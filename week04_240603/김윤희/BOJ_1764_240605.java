import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764 {

    static HashSet<String> pers;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        pers = new HashSet<>();
        for(int i = 0; i < N; i++) {
            pers.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            if (pers.contains(str)) {
                list.add(str);
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
