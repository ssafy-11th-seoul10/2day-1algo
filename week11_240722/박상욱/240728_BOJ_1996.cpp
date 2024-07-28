#include <bits/stdc++.h>

using namespace std;

char arr[1001][1001];

int N;

char count(int x, int y) {

	if ((arr[x][y] - '0') >= 1 && (arr[x][y] - '0') <= 9)
		return '*';

	int cnt = 0;
	for (int i = -1; i < 2; i++) {
		for (int j = -1; j < 2; j++) {
			if (x + i >= N || y + j >= N || x + i < 0 || y + j < 0)continue;
			if (i == 0 && j == 0)continue;
			if ((int)(arr[x + i][y + j] - '0') >= 1 && (int)(arr[x + i][y + j] - '0') <= 9)
				cnt += (int)(arr[x + i][y + j] - '0');
		}
	}

	if (cnt > 9) {
		return 'M';
	}
	else {
		return (char)('0' + cnt);
	}
}

int main() {
	
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cout << count(i, j);
		}
		cout << "\n";
	}

	return 0;
}

