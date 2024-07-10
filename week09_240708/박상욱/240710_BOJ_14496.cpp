#include<iostream>
#include<cmath>
#include<vector>
#include<algorithm>
#include<queue>
#include<climits>

using namespace std;

int visit[1001] = { 0, };
int check[1001][1001] = { 0, };

int main() {

	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	int a, b;
	cin >> a >> b;
	int N, M;
	cin >> N >> M;

	for (int i = 1; i <= N; i++) {
		visit[i] = INT_MAX;
	}

	for (int i = 0; i < M; i++) {
		int n, m;
		cin >> n >> m;

		check[n][m] = 1;
		check[m][n] = 1;
	}

	//N, 횟수
	queue<pair<int, int>> q;

	visit[a] = 0;
	q.push({ a,0 });

	while (!q.empty()) {
		int num = q.front().first;
		int cnt = q.front().second;

		if (num == b) {
			visit[cnt];
			break;
		}
		q.pop();

		for (int i = 1; i <= N; i++) {
			if (check[num][i] == 1) {
				if (visit[i] > cnt + 1) {
					visit[i] = cnt + 1;
					q.push({ i,cnt + 1 });
				}
			}
		}
	}

	if (visit[b] == INT_MAX) {
		visit[b] = -1;
	}
	cout << visit[b];


	return 0;
}