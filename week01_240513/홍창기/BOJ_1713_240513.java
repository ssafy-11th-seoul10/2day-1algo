import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1713_240513 {

    static class Student {
        int recommendedCount;
        int recommendedTime;

        public void init() {
            recommendedCount = 0;
            recommendedTime = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Student[] students = new Student[101];
        int studentCurNum = 0;

        for (int i = 1; i <= 100; i++) {
            students[i] = new Student();
        }

        for (int t = 0; t < m; t++) {
            int x = Integer.parseInt(st.nextToken());

            if (studentCurNum < n) {
                // 비어있는 사진틀이 있는 경우

                if (++students[x].recommendedCount == 1) {
                    students[x].recommendedTime = t;
                    studentCurNum++;
                }
            } else if (students[x].recommendedCount > 0) {
                // 비어있는 사진틀이 없지만 현재 학생이 이미 게시된 경우

                students[x].recommendedCount++;
            } else {
                // 비어있는 사진틀이 없고 현재 학생이 게시되지 않은 경우

                int minRecommendedCount = 1001;
                int minRecommendedTime = 1001;
                int minStudentNum = 1;

                for (int i = 1; i <= 100; i++) {
                    if (students[i].recommendedCount == 0) {
                        continue;
                    }

                    if (students[i].recommendedCount < minRecommendedCount) {
                        minRecommendedCount = students[i].recommendedCount;
                        minRecommendedTime = students[i].recommendedTime;
                        minStudentNum = i;
                    } else if (students[i].recommendedCount == minRecommendedCount) {
                        if (students[i].recommendedTime < minRecommendedTime) {
                            minRecommendedTime = students[i].recommendedTime;
                            minStudentNum = i;
                        }
                    }
                }

                students[minStudentNum].init();
                students[x].recommendedCount = 1;
                students[x].recommendedTime = t;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 100; i++) {
            if (students[i].recommendedCount > 0) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }

}
