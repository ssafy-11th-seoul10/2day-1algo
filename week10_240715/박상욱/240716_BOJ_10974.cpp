#include<bits/stdc++.h>

using namespace std;

int N;
int visit[9] = { 0, };
int str[9];

void DFS(int cnt) {
	for (int i = 1; i <= N; i++) {
		if (!visit[i]) {
			visit[i] = 1;

			str[cnt] = i;

			if (cnt + 1 == N) {
				for (int j = 0; j < N; j++) {
					cout << str[j] << " ";
				}
				cout << "\n";
			}
			else {
				DFS(cnt+1);
			}

			visit[i] = 0;
		}
	}
}

int main() {

	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);


	cin >> N;

	DFS(0);

	return 0;
}