import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());
        boolean revMode = false;

        while (T.length() > S.length()){
            char c = T.charAt(revMode ? 0 : T.length() - 1);

            T.deleteCharAt(revMode ? 0 : T.length() - 1);
            if (c == 'B'){
                revMode = !revMode;
            }
        }

        if (revMode){
            T.reverse();
        }
        System.out.println(S.contentEquals(T) ? 1 : 0);
    }

}
