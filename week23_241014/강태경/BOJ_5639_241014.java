package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639_241014 {

    static class Node{
        int num;
        Node left;
        Node right;

        public Node(int num){
            this.num = num;
        }
    }

    static Node insert(Node root, int num){
        if(root==null){
            return new Node(num);
        }
        if(root.num<num){
            root.right = insert(root.right, num);
        } else {
            root.left = insert(root.left, num);
        }
        return root;
    }

    static void postOrder(Node root){
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            sb.append(root.num).append("\n");
        }
    }

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String buffer = br.readLine();
        while (buffer != null) {
            int next = Integer.parseInt(buffer);
            insert(root, next);
            buffer = br.readLine();
        }

        sb = new StringBuilder();
        postOrder(root);
        System.out.println(sb);
    }
}
