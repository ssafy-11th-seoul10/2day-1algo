import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_240618_16508 {
    static class Book {
        int price;
        String title;

        public Book(int price, String title) {
            this.price = price;
            this.title = title;
        }
    }

    static String target;
    static Book[] books;
    static int n;
    static int[] count;
    static int[] selectCount;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        target = st.nextToken();
        count = new int[26];
        selectCount = new int[26];

        for (int i = 0; i < target.length(); i++) {
            count[target.charAt(i) - 'A']++;
        }

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        books = new Book[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int price = Integer.parseInt(st.nextToken());
            String title = st.nextToken();

            Book book = new Book(price, title);
            books[i] = book;
        }

        answer = 1_000_000;
        backtrack(0, 0);

        if (answer == 1_000_000) {
            sb.append(-1).append("\n");
            System.out.println(sb);
        } else {
            sb.append(answer).append("\n");
            System.out.println(sb);
        }

    }

    static void backtrack(int depth, int sum) {
        if (depth == n) {
            if (check())
                answer = Math.min(answer, sum);
            return;
        }

        Book book = books[depth];
        String title = book.title;
        int price = book.price;

        for (int i = 0; i < title.length(); i++) {
            selectCount[title.charAt(i) - 'A']++;
        }
        backtrack(depth + 1, sum + price);
        for (int i = 0; i < title.length(); i++) {
            selectCount[title.charAt(i) - 'A']--;
        }
        backtrack(depth + 1, sum);
    }

    static boolean check() {
        for (int i = 0; i < 26; i++) {
            if (count[i] > selectCount[i])
                return false;
        }

        return true;
    }
}
