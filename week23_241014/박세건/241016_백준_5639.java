import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int val;
        Node left;
        Node right;


        public Node(int val) {
            this.val = val;
        }
    }

    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, K;


    public static void main(String[] args) throws Exception {
        String input = "";
        List<Integer> inputList = new ArrayList<>();
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            inputList.add(Integer.parseInt(input));
        }
        Node root = new Node(inputList.get(0));
        for (int i = 1; i < inputList.size(); i++) {
            addNode(root, inputList.get(i));
        }

        makePostOrder(root);

    }

    private static void makePostOrder(Node root) {
        if (root.left != null) {
            makePostOrder(root.left);
        }
        if (root.right != null) {
            makePostOrder(root.right);
        }
        System.out.println(root.val);
    }

    private static void addNode(Node root, int val) {
        if (root.val > val) {
            if (root.left == null) {
                root.left = new Node(val);
            } else {
                addNode(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(val);
            } else {
                addNode(root.right, val);
            }
        }
    }
}
