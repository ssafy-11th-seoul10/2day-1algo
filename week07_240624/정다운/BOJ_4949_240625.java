import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {

    static Stack<Character> stack;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();

            if(str.length() == 1 && str.charAt(0) == '.') {
                break;
            }

            boolean balance = true;
            stack = new Stack<>();

            for(int i = 0; i < str.length(); i++) {

                char tmp = str.charAt(i);

                if(tmp == '(' || tmp == '[')
                    stack.add(tmp);

                else if(tmp == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        balance = false;
                        break;
                    }
                    else
                        stack.pop();
                }

                else if(tmp == ']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        balance = false;
                        break;
                    }
                    else
                        stack.pop();
                }

            }

            if(!stack.isEmpty())
                balance = false;

            if(balance) {
                sb.append("yes").append("\n");
            }
            else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }
}
