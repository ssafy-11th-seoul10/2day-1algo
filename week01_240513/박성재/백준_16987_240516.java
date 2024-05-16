import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_16987_240516 {
  static class Egg {
    int hp; // 내구도
    int weight; // 무게

    public Egg(int hp, int weight) {
      this.hp = hp;
      this.weight = weight;
    }
  }

  static Egg[] eggArr;
  static int n;
  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    n = Integer.parseInt(st.nextToken());
    eggArr = new Egg[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int hp = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      Egg egg = new Egg(hp, weight);
      eggArr[i] = egg;
    }

    answer = 0;
    backtrack(0, 0);
    sb.append(answer).append("\n");
    System.out.println(sb);
  }

  static void backtrack(int depth, int count) {
    if (depth == n) {
      answer = Math.max(answer, count);
      return;
    }

    Egg now = eggArr[depth];

    if (now.hp <= 0) {
      backtrack(depth + 1, count);
      return;
    }
    boolean flag = false; // 한개라도 깨는지 체크
    for (int i = 0; i < n; i++) {
      int zero = 0;
      if (i == depth)
        continue;

      Egg egg = eggArr[i];
      if (egg.hp <= 0)
        continue;

      flag = true;
      int temp1 = now.hp;
      int temp2 = egg.hp;

      now.hp -= egg.weight;
      egg.hp -= now.weight;

      if (now.hp <= 0) {
        now.hp = 0;
        zero++;
      }

      if (egg.hp <= 0) {
        egg.hp = 0;
        zero++;
      }

      backtrack(depth + 1, count + zero);

      now.hp = temp1;
      egg.hp = temp2;
    }

    if (!flag)
      backtrack(depth + 1, count);
  }
}
