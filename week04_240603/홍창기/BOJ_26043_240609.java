import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_26043_240609 {

    static class StudentMenu {
        int studentNum, menuNum;

        StudentMenu(int studentNum, int menuNum) {
            this.studentNum = studentNum;
            this.menuNum = menuNum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayDeque<StudentMenu> waitingQueue = new ArrayDeque<StudentMenu>();
        ArrayList<Integer> aList = new ArrayList<Integer>();
        ArrayList<Integer> bList = new ArrayList<Integer>();
        ArrayList<Integer> cList = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int studentNum = Integer.parseInt(st.nextToken());
                int menuNum = Integer.parseInt(st.nextToken());
                waitingQueue.offer(new StudentMenu(studentNum, menuNum));
            } else {
                int menuNum = Integer.parseInt(st.nextToken());
                StudentMenu front = waitingQueue.poll();

                if (front.menuNum == menuNum) {
                    aList.add(front.studentNum);
                } else {
                    bList.add(front.studentNum);
                }
            }
        }

        while (!waitingQueue.isEmpty()) {
            cList.add(waitingQueue.poll().studentNum);
        }

        Collections.sort(aList);
        Collections.sort(bList);
        Collections.sort(cList);
        StringBuilder sb = new StringBuilder();

        if (aList.size() == 0) {
            sb.append("None\n");
        } else {
            for (int a : aList) {
                sb.append(a).append(" ");
            }

            sb.append("\n");
        }

        if (bList.size() == 0) {
            sb.append("None\n");
        } else {
            for (int b : bList) {
                sb.append(b).append(" ");
            }

            sb.append("\n");
        }

        if (cList.size() == 0) {
            sb.append("None\n");
        } else {
            for (int c : cList) {
                sb.append(c).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}
