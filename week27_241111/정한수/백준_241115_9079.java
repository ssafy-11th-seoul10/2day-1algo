import java.io.*;
import java.util.*;

public class Main {

    // n번째 Set은 연산 n개로 가능한 모든 경우의 집합
    private static final List<Set<Integer>> casesOf;
    private static final int[] operations = {
            0b111_000_000,
            0b000_111_000,
            0b000_000_111,
            0b100_100_100,
            0b010_010_010,
            0b001_001_001,
            0b100_010_001,
            0b001_010_100
    };
    static {
        casesOf = new ArrayList<>();
        casesOf.add(new HashSet<>());
        casesOf.get(0).add(0b000_000_000);
        casesOf.get(0).add(0b111_111_111);
    }

    private static void updateCases(){
        Set<Integer> prevSet = casesOf.get(casesOf.size() - 1);
        Set<Integer> nextSet = new HashSet<>();

        for (int cases : prevSet){
            for (int operation : operations){
                nextSet.add(cases ^ operation);
            }
        }
        casesOf.add(nextSet);
    }

    private static int getMinOperationCount(int coins){
        // 연산의 횟수는 최대 8개(연산의 개수)
        for (int i = 0; i <= operations.length; i++){
            // Lazy 업데이트
            if (i == casesOf.size()){
                updateCases();
            }

            if (casesOf.get(i).contains(coins)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int coins = 0;

            for (int i = 0; i < 3; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++){
                    coins = (coins << 1) | ("H".equals(st.nextToken()) ? 1 : 0);
                }
            }
            sb.append(getMinOperationCount(coins)).append("\n");
        }
        System.out.print(sb);
    }

}
