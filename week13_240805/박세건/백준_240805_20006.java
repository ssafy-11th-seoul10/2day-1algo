import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;

    static class Player {
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<List<Player>> players = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            boolean isJoin = false;
            for (List<Player> playerList : players) {
                Player leader = playerList.get(0);
                if (playerList.size() < M && Math.abs(player.level - leader.level) <= 10) {
                    isJoin = true;
                    playerList.add(player);
                    break;
                }
            }
            if (!isJoin) {
                List<Player> newRoom = new ArrayList<>();
                newRoom.add(player);
                players.add(newRoom);
            }
        }
        for (List<Player> player : players) {
            player.sort((player1, player2) -> player1.name.compareTo(player2.name));
        }
        for (List<Player> player : players) {
            if (player.size() == M) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            for (Player player1 : player) {
                System.out.println(player1.level + " " + player1.name);
            }
        }
    }
}
