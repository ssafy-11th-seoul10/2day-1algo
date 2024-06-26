#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

char board[2001][2001];
int prefix[2001][2001];

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		
	int N, M, K;
	cin >> N >> M >> K;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
		}
	}

	char color = 'B';
	int m = 2000 * 2000;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			char c = board[i][j];

			//짝수인 경우 같은 색
			if ((i + j) % 2 == 0) {
				prefix[i+1][j+1] = prefix[i+1][j] + prefix[i][j + 1] - prefix[i][j] + (color == c ? 0 : 1);
			}
			else {
				prefix[i+1][j+1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j] + (color == c ? 1 : 0);
			}
		}
	}

	for (int i = 1; i <= N-K+1; i++) {
		for (int j = 1; j <= M-K+1; j++) {
			int mPre = prefix[i + K - 1][j + K - 1] - prefix[i + K - 1][j - 1] - prefix[i - 1][j + K - 1] + prefix[i - 1][j - 1];
			if (mPre < m) {
				m = mPre;
			}
		}
	}

	color = 'W';
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			char c = board[i][j];

			//짝수인 경우 같은 색
			if ((i + j) % 2 == 0) {
				prefix[i + 1][j + 1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j] + (color == c ? 0 : 1);
			}
			else {
				prefix[i + 1][j + 1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j] + (color == c ? 1 : 0);
			}
		}
	}

	for (int i = 1; i <= N - K + 1; i++) {
		for (int j = 1; j <= M - K + 1; j++) {
			int mPre = prefix[i + K - 1][j + K - 1] - prefix[i + K - 1][j - 1] - prefix[i - 1][j + K - 1] + prefix[i - 1][j - 1];
			if (mPre < m) {
				m = mPre;
			}
		}
	}

	cout << m << "\n";
	

	return 0;
}

