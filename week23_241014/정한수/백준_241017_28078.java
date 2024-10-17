import java.io.*;
import java.util.*;

// mode 0: →, mode 1: ↓, mode 2: ←, mode 3: ↑
class GravityQueue {

    private enum Element {BALL, WALL}

    private final Deque<Element> queue = new ArrayDeque<>();
    private int mode = 0;
    private int ballCnt = 0;
    private int wallCnt = 0;

    public void pushBall() {
        queue.addLast(Element.BALL);
        ballCnt++;
        applyGravity();
    }

    public void pushWall() {
        queue.addLast(Element.WALL);
        wallCnt++;
        applyGravity();
    }

    public void pop()  {
        if (queue.isEmpty()) {
            return;
        }

        Element e = queue.removeFirst();
        if (e == Element.BALL) {
            ballCnt--;
        } else if (e == Element.WALL) {
            wallCnt--;
        }

        applyGravity();
    }

    public void rotateRight() {
        mode = (mode + 1) % 4;
        applyGravity();
    }

    public void rotateLeft() {
        mode = (mode + 3) % 4;
        applyGravity();
    }

    public int countBall() {
        return ballCnt;
    }

    public int countWall() {
        return wallCnt;
    }

    private void applyGravity() {
        switch (mode) {
            case 0: case 2:
                break;
            case 1:
                while (!queue.isEmpty() && queue.peekFirst() == Element.BALL) {
                    queue.removeFirst();
                    ballCnt--;
                }
                break;
            case 3:
                while (!queue.isEmpty() && queue.peekLast() == Element.BALL) {
                    queue.removeLast();
                    ballCnt--;
                }
                break;
        }
    }
}

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static final GravityQueue gq = new GravityQueue();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            execute(st);
        }
        System.out.print(sb);
    }

    private static void execute(StringTokenizer st){
        switch (st.nextToken()){
            case "push":
                if ("b".equals(st.nextToken())){
                    gq.pushBall();
                } else {
                    gq.pushWall();
                }
                break;

            case "pop":
                gq.pop();
                break;

            case "rotate":
                if ("l".equals(st.nextToken())){
                    gq.rotateLeft();
                } else {
                    gq.rotateRight();
                }
                break;

            case "count":
                if ("b".equals(st.nextToken())){
                    sb.append(gq.countBall()).append("\n");
                } else {
                    sb.append(gq.countWall()).append("\n");
                }
                break;
        }
    }

}
