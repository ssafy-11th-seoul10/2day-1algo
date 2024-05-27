import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// get input
		int N = Integer.parseInt(br.readLine());

		// process
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = '*';
			}
		}
		rec(0, 0, N);

		// output
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void rec(int row, int col, int length) {
		if (length <= 1)
			return;

		// row + length / 3부터 length / 3 크기만큼
		// col + length / 3부터 length / 3 크기만큼
		// char 배열을 빈칸으로 만듦
		int startRow = row + length / 3;
		int startCol = col + length / 3;
		int size = length / 3;

		for (int i = startRow; i < startRow + size; i++) {
			for (int j = startCol; j < startCol + size; j++) {
				arr[i][j] = ' ';
			}
		}

		// 그 후 가운데를 제외한 8 방향에서 다시 rec 함수 호출
		rec(row, col, size);
		rec(row, col + size, size);
		rec(row, col + size * 2, size);
		
		rec(row + size, col, size);
		rec(row + size, col + size * 2, size);
		
		rec(row + size * 2, col, size);
		rec(row + size * 2, col + size, size);
		rec(row + size * 2, col + size * 2, size);
	}

}
