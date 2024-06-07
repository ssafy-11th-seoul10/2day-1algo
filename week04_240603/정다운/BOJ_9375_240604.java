import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ9375 {

    static int TC;
    static Map<String, Integer> clothes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());

        for(int test = 0; test < TC; test++) {
            clothes = new TreeMap<>();

            int numOfClothes = Integer.parseInt(br.readLine());

            for(int num = 0; num < numOfClothes; num++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String kind = st.nextToken();

                if(clothes.get(kind) != null)
                    clothes.put(kind, clothes.get(kind) + 1);
                else
                    clothes.putIfAbsent(kind, 1);
            }

            int result = 1;
            // 안 입는 경우 => +1 하기
            for(int cloth : clothes.values())
                result *= (cloth + 1);

            // 알몸은 제외
            System.out.println(result - 1);
        }
    }
}
