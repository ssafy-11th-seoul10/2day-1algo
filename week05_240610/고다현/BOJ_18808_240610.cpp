#include <iostream>
#include <algorithm>
#include <queue>
#include <string>
#include <vector>

using namespace std;

/*18808*/

struct info {
	int h, w;
	int puzzle[11][11];
};
int N, M, K;
int cnt = 0;
vector<vector<bool>> board(41, vector<bool>(41, false));
vector<info> stickers(101);

void print_board() {
	cout << "===========board==========\n";
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j]) cout << 1;
			else cout << 0;
			cout << ' ';
		}
		cout << "\n";
	}
}


bool check_place(int k, int dir) {
	// 퍼즐 회전하기
	int ph, pw;
	int tempPuzzle[11][11];
	int aa = 0, bb = 0;

	if (dir == 0) {
		ph = stickers[k].h;
		pw = stickers[k].w;
		for (int a = 0; a < stickers[k].h; a++) {
			bb = 0;
			for (int b = 0; b < stickers[k].w; b++) {
				tempPuzzle[aa][bb++] = stickers[k].puzzle[a][b];
			}
			aa++;
		}
	}
	else if (dir == 1) {
		ph = stickers[k].w;
		pw = stickers[k].h;

		for (int b = 0; b < stickers[k].w; b++) {
			bb = 0;
			for (int a = 0; a < stickers[k].h; a++) {
				tempPuzzle[aa][bb++] = stickers[k].puzzle[stickers[k].h - a - 1][b];
			}
			aa++;
		}
	}
	else if (dir == 2) {
		ph = stickers[k].h;
		pw = stickers[k].w;

		for (int a = stickers[k].h - 1; a >= 0; a--) {
			bb = 0;
			for (int b = stickers[k].w - 1; b >= 0; b--) {
				tempPuzzle[aa][bb++] = stickers[k].puzzle[a][b];
			}
			aa++;
		}
	}
	else if (dir == 3) {
		ph = stickers[k].w;
		pw = stickers[k].h;

		for (int b = stickers[k].w - 1; b >= 0; b--) {
			bb = 0;
			for (int a = stickers[k].h - 1; a >= 0; a--) {
				tempPuzzle[aa][bb++] = stickers[k].puzzle[stickers[k].h - a - 1][b];
			}
			aa++;
		}
	}

	bool hasPlace = false;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			// 확인
			bool hasSpace = true;
			for (int a = 0; a < ph; a++) {
				for (int b = 0; b < pw; b++) {

					// 범위 안에 존재할 경우
					if (i + a >= 0 && i + a < N && j + b >= 0 && j + b < M) {
						if (board[i + a][j + b] && tempPuzzle[a][b] == 1) {
							hasSpace = false;
							break;
						}
					}
					else {
						hasSpace = false;
						break;
					}

					if (a == ph - 1 && b == pw - 1 && hasSpace) {
						hasPlace = true;
					}
				}
				if (!hasSpace) break;
			}
			if (hasPlace) {
				for (int a = 0; a < ph; a++) {
					for (int b = 0; b < pw; b++) {
						if (tempPuzzle[a][b] == 1) {
							board[i + a][j + b] = true;
							cnt++;
						}
					}
				}

				return true;
			}
		}
	}
	return false;
}

int main() {
	cin >> N >> M >> K;

	for (int k = 0; k < K; k++) {
		cin >> stickers[k].h >> stickers[k].w;

		for (int i = 0; i < stickers[k].h; i++) {
			for (int j = 0; j < stickers[k].w; j++) {
				cin >> stickers[k].puzzle[i][j];
			}
		}
	}

	// sticker 들이 board 순회
	for (int k = 0; k < K; k++) {
		int dir = 0;

		while (dir < 4) {
			if (check_place(k, dir)) {
				//cout << "K: " << k << ", dir: " << dir << '\n';
				//print_board();
				break;
			}

			dir++;
		}
	}

	cout << cnt;
}