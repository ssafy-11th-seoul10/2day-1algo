package soHard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        char[][] board = new char[n][n];    //    n x n 의 배열 생성
        for(char[] row: board)                // 배열을 전부 . 로 채움
            Arrays.fill(row, '.');

        int x = 0, y = 0;                    // 판 위에서 로봇 팔의 위치를 나타낼 인덱스 변수

        for(int i = 0; i < s.length(); i++) {
            char move = s.charAt(i);

            switch(move) {
                case 'D':
                    if(x != n-1) {                // 로봇 팔이 아래로 더 움직일 수 있는지 확인

                        if(board[x][y] == '.') {
                            board[x][y] = '|';
                        }else if(board[x][y] == '-') {
                            board[x][y] = '+';
                        }
                        x++;
                        if(board[x][y] == '.') {
                            board[x][y] = '|';
                        }else if(board[x][y] == '-') {
                            board[x][y] = '+';
                        }
                    }
                    break;
                case 'U':
                    if(x != 0) {                // 로봇 팔이 위로 더 움직일 수 있는지 확인
                        if(board[x][y] == '.') {
                            board[x][y] = '|';
                        }else if(board[x][y] == '-') {
                            board[x][y] = '+';
                        }
                        x--;
                        if(board[x][y] == '.') {
                            board[x][y] = '|';
                        }else if(board[x][y] == '-') {
                            board[x][y] = '+';
                        }
                    }

                    break;
                case 'L':
                    if(y != 0) {                // 로봇 팔이 왼쪽으로 더 움직일 수 있는지 확인
                        if(board[x][y] == '.') {
                            board[x][y] = '-';
                        }else if(board[x][y] == '|') {
                            board[x][y] = '+';
                        }
                        y--;
                        if(board[x][y] == '.') {
                            board[x][y] = '-';
                        }else if(board[x][y] == '|') {
                            board[x][y] = '+';
                        }
                    }
                    break;
                case 'R':
                    if(y != n-1) {                // 로봇 팔이 오른쪽으로 더 움직일 수 있는지 확인
                        if(board[x][y] == '.') {
                            board[x][y] = '-';
                        }else if(board[x][y] == '|') {
                            board[x][y] = '+';
                        }
                        y++;
                        if(board[x][y] == '.') {
                            board[x][y] = '-';
                        }else if(board[x][y] == '|') {
                            board[x][y] = '+';
                        }
                    }
                    break;
            }
        }
        for(int i = 0; i < n; i++) {            // 결과물 출력
            for(int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
