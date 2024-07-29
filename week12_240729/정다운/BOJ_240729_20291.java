package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ20291 {

    static Map<String, List<String>> backPoint = new TreeMap<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split("\\.");

            String head = tmp[0]; String tail = tmp[1];

            if(backPoint.get(tail) == null)
                backPoint.put(tail, new ArrayList<>());

            backPoint.get(tail).add(head);
        }

        for(Map.Entry<String, List<String>> entry : backPoint.entrySet()) {

            int size = entry.getValue().size();
            String tail = entry.getKey();

            System.out.println(tail + " " + size);
        }
    }
}
