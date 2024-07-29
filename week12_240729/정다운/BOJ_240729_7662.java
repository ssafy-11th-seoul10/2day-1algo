package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ7662 {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        // TreeMap -> key값 정렬
        for(int test_case = 0; test_case < T; test_case++) {

            TreeMap<Integer, Integer> myMap = new TreeMap<>();
            int count = Integer.parseInt(br.readLine());

            for(int j = 0; j < count; j++){
                st = new StringTokenizer(br.readLine());

                String command = st.nextToken();
                int data = Integer.parseInt(st.nextToken());

                if(command.equals("I")) {
                    if(myMap.get(data) == null)
                        myMap.put(data, 1);
                    else
                        myMap.put(data, myMap.get(data) + 1);
                }

                else if(command.equals("D")) {

                    if(myMap.isEmpty())
                        continue;

                    Map.Entry<Integer, Integer> entry = null;

                    if(data == -1)
                        entry = myMap.firstEntry();
                    else
                        entry = myMap.lastEntry();

                    if(entry.getValue() == 1)
                        myMap.remove(entry.getKey());
                    else
                        myMap.put(entry.getKey(), entry.getValue() - 1);
                }
            }

            if(myMap.isEmpty())
                System.out.println("EMPTY");

            else {
                Map.Entry<Integer, Integer> firstEntry = myMap.firstEntry();
                Map.Entry<Integer, Integer> lastEntry = myMap.lastEntry();

                System.out.println(lastEntry.getKey() + " " + firstEntry.getKey());
            }

        }
    }
}
