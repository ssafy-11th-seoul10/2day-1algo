import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Character> charSet = new HashSet<>();
        int N = Integer.parseInt(br.readLine());

        a: while (N-- > 0){
            String[] option = br.readLine().split(" ");

            for (int i = 0; i < option.length; i++){
                if (!charSet.contains(Character.toLowerCase(option[i].charAt(0)))){
                    charSet.add(Character.toLowerCase(option[i].charAt(0)));
                    option[i] = "[" + option[i].charAt(0) + "]" + option[i].substring(1);
                    for (String word : option){
                        sb.append(word).append(' ');
                    }
                    sb.append('\n');
                    continue a;
                }
            }

            for (int i = 0; i < option.length; i++){
                for (int j = 1; j < option[i].length(); j++){
                    if (!charSet.contains(Character.toLowerCase(option[i].charAt(j)))){
                        charSet.add(Character.toLowerCase(option[i].charAt(j)));
                        option[i] = option[i].substring(0, j) + "[" + option[i].charAt(j) + "]" + option[i].substring(j + 1);
                        for (String word : option){
                            sb.append(word).append(' ');
                        }
                        sb.append('\n');
                        continue a;
                    }
                }
            }

            for (String word : option){
                sb.append(word).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
