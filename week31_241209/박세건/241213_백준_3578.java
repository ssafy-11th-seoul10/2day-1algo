import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            runTestCase();
        }
    }

    private static void runTestCase() throws IOException {
        st = new StringTokenizer(br.readLine());
        int teamCnt = Integer.parseInt(st.nextToken());
        int problemCnt = Integer.parseInt(st.nextToken());
        int myTeamId = Integer.parseInt(st.nextToken());
        int logCnt = Integer.parseInt(st.nextToken());
        int[][] teamInfos = new int[teamCnt + 1][4]; //[팀 점수, 제출횟수, 마지막 로그 번호,팀ID]
        for (int i = 0; i < teamInfos.length; i++) {
            teamInfos[i][3] = i;
        }
        createTeamInfo(teamInfos, teamCnt, problemCnt, logCnt);
        Arrays.sort(teamInfos, (teamInfo1, teamInfo2) -> {
            if (teamInfo1[0] == teamInfo2[0]) {
                if (teamInfo1[1] == teamInfo2[1]) {
                    return teamInfo1[2] - teamInfo2[2];
                } else {
                    return teamInfo1[1] - teamInfo2[1];
                }
            } else {
                return -(teamInfo1[0] - teamInfo2[0]);
            }
        });
        for (int i = 0; i < teamInfos.length; i++) {
            if (teamInfos[i][3] == myTeamId) {
                System.out.println(i + 1);
            }
        }
    }

    private static void createTeamInfo(int[][] teamInfos, int teamCnt, int problemCnt, int logCnt) throws IOException {
        int[][] scoreMap = new int[teamCnt + 1][problemCnt + 1];
        for (int i = 0; i < logCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int teamId = Integer.parseInt(st.nextToken());
            int problemNum = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            scoreMap[teamId][problemNum] = Math.max(scoreMap[teamId][problemNum], score);
            teamInfos[teamId][1]++;
            teamInfos[teamId][2] = Math.max(i, teamInfos[teamId][2]);
        }
        for (int i = 1; i < teamCnt + 1; i++) {
            int sum = 0;
            for (int j = 1; j < problemCnt + 1; j++) {
                sum += scoreMap[i][j];
            }
            teamInfos[i][0] = sum;
        }
    }
}
