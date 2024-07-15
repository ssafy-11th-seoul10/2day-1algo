#include <bits/stdc++.h>

using namespace std;

char arr[51][51] = { 0, };
char ans[51][51] = { 0, };

int main() {
	
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N, M;

	int cnt = 0;
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> ans[i][j];
		}
	}

	for (int i = 0; i <= N-3; i++) {
		for (int j = 0; j <= M-3; j++) {
			if (arr[i][j] != ans[i][j]) {
				cnt++;
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if (arr[i + k][j + l] == '0') {
							arr[i + k][j + l] = '1';
						}
						else {
							arr[i + k][j + l] = '0';
						}
					}
				}
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (arr[i][j] != ans[i][j]) {
				cout << -1 << "\n";
				return 0;
			}
		}
	}

	cout << cnt << "\n";
	

	return 0;
}

