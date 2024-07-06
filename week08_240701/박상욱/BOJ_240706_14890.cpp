#include <bits/stdc++.h>

using namespace std;

int arr[101][101];
int visit[101][101];

int main() {
	
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N, L;
	cin >> N >> L;

	int cnt = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
		}
	}

	//가로 
	for (int i = 0; i < N; i++) {
		int flag = 1;
		for (int j = 0; j < N-1; j++) {
			if (arr[i][j] == arr[i][j + 1])continue;
			else {
				//오른쪽 경사로
				if (arr[i][j] - arr[i][j + 1] == 1) {
					if (N - (j + 1) < L) {
						flag = 0;
						break;
					}
					for (int k = j + 1; k <= j + L; k++) {
						//높이가 다른 경우
						if (arr[i][j] != arr[i][k] + 1) {
							flag = 0;
							break;
						}
						//이미 경사로가 설치된 경우
						if (visit[i][k]) {
							flag = 0;
							break;
						}
						visit[i][k] = i + 1;
					}
					//경사로를 설치할 수 없는 경우
					if (!flag) {
						for (int k = j + 1; k < j + L; k++) {
							visit[i][k] = 0;
						}
					}
				}
				//왼쪽 경사로
				else if (arr[i][j] - arr[i][j + 1] == -1) {
					if (j + 1 < L) {
						flag = 0;
						break;
					}
					for (int k = j; k > j - L; k--) {
						//높이가 다른 경우
						if (arr[i][j + 1] != arr[i][k] + 1) {
							flag = 0;
							break;
						}
						//이미 경사로가 설치된 경우
						if (visit[i][k]) {
							flag = 0;
							break;
						}
						visit[i][k] = i + 1;
					}
					//경사로를 설치할 수 없는 경우
					if (!flag) {
						for (int k = j; k > j - L; k--) {
							visit[i][k] = 0;
						}
					}
				}
				//경사로를 세우지 못하는 경우
				else {
					flag = 0;
					break;
				}
			}
		}
		if (flag) {
			cnt++;
		}
		else {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == i + 1)visit[i][j] = 0;
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			visit[i][j] = 0;
		}
	}

	//세로 
	for (int j = 0; j < N; j++) {
		int flag = 1;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i][j] == arr[i + 1][j])continue;
			else {
				//아래 경사로
				if (arr[i][j] - arr[i + 1][j] == 1) {
					if (N - (i + 1) < L) {
						flag = 0;
						break;
					}
					for (int k = i + 1; k <= i + L; k++) {
						//높이가 다른 경우
						if (arr[i][j] != arr[k][j] + 1) {
							flag = 0;
							break;
						}
						//이미 경사로가 설치된 경우
						if (visit[k][j]) {
							flag = 0;
							break;
						}
						visit[k][j] = j + 101;
					}
				}
				//위 경사로
				else if (arr[i][j] - arr[i + 1][j] == -1) {
					if (i + 1 < L) {
						flag = 0;
						break;
					}
					for (int k = i; k > i - L; k--) {
						//높이가 다른 경우
						if (arr[i + 1][j] != arr[k][j] + 1) {
							flag = 0;
							break;
						}
						//이미 경사로가 설치된 경우
						if (visit[k][j]) {
							flag = 0;
							break;
						}
						visit[k][j] = j + 101;
					}
				}
				//경사로를 세우지 못하는 경우
				else {
					flag = 0;
					break;
				}
			}
		}
		if (flag) {
			cnt++;
		}
		else {
			for (int i = 0; i < N; i++) {
				if (visit[i][j] == j + 101)visit[i][j] = 0;
			}
		}
	}

	cout << cnt << "\n";

	
	return 0;
}

