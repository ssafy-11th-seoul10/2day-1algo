import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
   private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        Set<String> stringSet=new HashSet<>();
        for (int i = 0; i < N; i++) {
            String tmp=bufferedReader.readLine();
            stringSet.add(tmp);
        }

        List<String> stringList = stringSet.stream().sorted((string1,string2)->{
            if(string1.length()==string2.length()){
                return string1.compareTo(string2);
            }
            return string1.length()-string2.length();
        }).collect(Collectors.toList());
        for (String string : stringList) {
            System.out.println(string);
        }
    }
}
