package PG;

public class PG_숫자문자열과영단어_240827 {
    public static void main(String[] args) {
        String s = "one4seveneight";

        s = s.replace("zero", "0")
                .replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9");
        System.out.println(Integer.parseInt(s));
    }
}
