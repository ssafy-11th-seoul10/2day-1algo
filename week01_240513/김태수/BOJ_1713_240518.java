import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Vote> list = new LinkedList<>();

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            boolean flag = false;
            int vote = Integer.parseInt(line[i]);

            for (Vote l : list) {
                if (l.num == vote) {
                    l.count++;
                    flag = true;
                }
            }

            if (!flag) {
                if (list.size() < n) {
                    list.add(new Vote(vote, 1, i));
                } else {
                    int count = 1001;
                    int index = 0;
                    int input = 1001;
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).count < count || changeOption(list, j, count, input)) {
                            count = list.get(j).count;
                            index = j;
                            input = list.get(j).inputTime;
                        }
                    }

                    list.remove(index);
                    list.add(new Vote(vote, 1, i));
                }
            }
        }

        list.stream().sorted().forEach(i -> System.out.print(i.num + " "));
    }

    private static boolean changeOption(List<Vote> list, int j, int count, int input) {
        return list.get(j).count == count && list.get(j).inputTime < input;
    }
}

class Vote implements Comparable<Vote> {
    int num;
    int count;
    int inputTime;

    public Vote(int num, int count, int inputTime) {
        this.num = num;
        this.count = count;
        this.inputTime = inputTime;
    }

    @Override
    public int compareTo(Vote o) {
        return this.num - o.num;
    }
}
