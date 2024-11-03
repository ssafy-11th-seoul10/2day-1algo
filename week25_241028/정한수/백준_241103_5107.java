import java.io.*;
import java.util.*;

public class Main {

    private static void traversalChain(Map<String, String> parents, String parentName){
        String ancientName = parentName;
        
        do {
            String childName = parents.get(parentName);
            parents.remove(parentName);
            parentName = childName;
        } while (!ancientName.equals(parentName));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1, N;

        while ((N = Integer.parseInt(br.readLine())) > 0){
            Map<String, String> parents = new HashMap<>();
            int chainCount = 0;

            for (int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                parents.put(st.nextToken(), st.nextToken());
            }

            while (!parents.isEmpty()){
                String parentName = parents.keySet().iterator().next();
                traversalChain(parents, parentName);
                chainCount++;
            }
            sb.append(tc++).append(" ").append(chainCount).append("\n");
        }

        System.out.print(sb);
    }

}
