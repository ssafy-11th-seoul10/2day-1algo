import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_240920_15683 {
    static int n;
    static int m;
    static int[][] map;
    static List<int[]> cctvList;
    static int[] ry = { 0, 1, 0, -1 };
    static int[] rx = { 1, 0, -1, 0 };
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        cctvList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if (num >= 1 && num <= 5)
                    cctvList.add(new int[] { i, j });
            }
        }

        backtrack(0);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void backtrack(int depth) {
        if (depth == cctvList.size()) {
            answer = Math.min(answer, count());
            return;
        }

        int[] now = cctvList.get(depth);
        int cctvNum = map[now[0]][now[1]];
        List<int[]> backupList = new ArrayList<>();

        cctvRun(cctvNum, backupList, now, depth);

    }

    static void cctvRun(int num, List<int[]> list, int[] now, int depth) {
        int nowY = now[0];
        int nowX = now[1];

        if (num == 1) {
            for (int i = 0; i < 4; i++) {
                nowY = now[0];
                nowX = now[1];
                while (true) {
                    int r = nowY + ry[i];
                    int c = nowX + rx[i];

                    if (r < 0 || c < 0 || r >= n || c >= m)
                        break;
                    if (map[r][c] == 6)
                        break;
                    if (map[r][c] == 0) {
                        map[r][c] = -1;
                        list.add(new int[] { r, c });
                    }

                    nowY = r;
                    nowX = c;

                }
                backtrack(depth + 1);
                backup(list);
            }
        } else if (num == 2) {
            for (int i = 0; i < 2; i++) {
                nowY = now[0];
                nowX = now[1];
                while (true) {
                    int r = nowY + ry[i];
                    int c = nowX + rx[i];

                    if (r < 0 || c < 0 || r >= n || c >= m)
                        break;
                    if (map[r][c] == 6)
                        break;
                    if (map[r][c] == 0) {
                        map[r][c] = -1;
                        list.add(new int[] { r, c });
                    }

                    nowY = r;
                    nowX = c;
                }

                nowY = now[0];
                nowX = now[1];
                while (true) {
                    int r = nowY + ry[i + 2];
                    int c = nowX + rx[i + 2];

                    if (r < 0 || c < 0 || r >= n || c >= m)
                        break;
                    if (map[r][c] == 6)
                        break;
                    if (map[r][c] == 0) {
                        map[r][c] = -1;
                        list.add(new int[] { r, c });
                    }

                    nowY = r;
                    nowX = c;
                }
                backtrack(depth + 1);
                backup(list);
            }
        } else if (num == 3) {
            for (int i = 0; i < 4; i++) {
                nowY = now[0];
                nowX = now[1];
                while (true) {
                    int r = nowY + ry[i];
                    int c = nowX + rx[i];

                    if (r < 0 || c < 0 || r >= n || c >= m)
                        break;
                    if (map[r][c] == 6)
                        break;
                    if (map[r][c] == 0) {
                        map[r][c] = -1;
                        list.add(new int[] { r, c });
                    }

                    nowY = r;
                    nowX = c;
                }

                nowY = now[0];
                nowX = now[1];
                while (true) {
                    int r = nowY + ry[(i + 1) % 4];
                    int c = nowX + rx[(i + 1) % 4];

                    if (r < 0 || c < 0 || r >= n || c >= m)
                        break;
                    if (map[r][c] == 6)
                        break;
                    if (map[r][c] == 0) {
                        map[r][c] = -1;
                        list.add(new int[] { r, c });
                    }

                    nowY = r;
                    nowX = c;
                }
                backtrack(depth + 1);
                backup(list);
            }
        } else if (num == 4) {
            for (int i = 0; i < 4; i++) {
                nowY = now[0];
                nowX = now[1];
                while (true) {
                    int r = nowY + ry[i];
                    int c = nowX + rx[i];

                    if (r < 0 || c < 0 || r >= n || c >= m)
                        break;
                    if (map[r][c] == 6)
                        break;
                    if (map[r][c] == 0) {
                        map[r][c] = -1;
                        list.add(new int[] { r, c });
                    }

                    nowY = r;
                    nowX = c;
                }

                nowY = now[0];
                nowX = now[1];
                while (true) {
                    int r = nowY + ry[(i + 1) % 4];
                    int c = nowX + rx[(i + 1) % 4];

                    if (r < 0 || c < 0 || r >= n || c >= m)
                        break;
                    if (map[r][c] == 6)
                        break;
                    if (map[r][c] == 0) {
                        map[r][c] = -1;
                        list.add(new int[] { r, c });
                    }

                    nowY = r;
                    nowX = c;
                }

                nowY = now[0];
                nowX = now[1];
                while (true) {
                    int r = nowY + ry[(i + 2) % 4];
                    int c = nowX + rx[(i + 2) % 4];

                    if (r < 0 || c < 0 || r >= n || c >= m)
                        break;
                    if (map[r][c] == 6)
                        break;
                    if (map[r][c] == 0) {
                        map[r][c] = -1;
                        list.add(new int[] { r, c });
                    }

                    nowY = r;
                    nowX = c;
                }
                backtrack(depth + 1);
                backup(list);
            }
        } else if (num == 5) {
            for (int i = 0; i < 4; i++) {
                nowY = now[0];
                nowX = now[1];

                while (true) {
                    int r = nowY + ry[i];
                    int c = nowX + rx[i];

                    if (r < 0 || c < 0 || r >= n || c >= m)
                        break;
                    if (map[r][c] == 6)
                        break;
                    if (map[r][c] == 0) {
                        map[r][c] = -1;
                        list.add(new int[] { r, c });
                    }

                    nowY = r;
                    nowX = c;
                }
            }

            backtrack(depth + 1);
            backup(list);
        }
    }

    static void backup(List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            int[] now = list.get(i);

            map[now[0]][now[1]] = 0;
        }
    }

    static int count() {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0)
                    answer++;
            }
        }

        return answer;
    }
}
