#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

vector<int>list [100001];
int visit[100001] = { 0, };;
int C[100001];

int N, R, Q;

int DFS(int num) {
	//cout << num << " ";
	int cnt = 1;
	for (int i = 0; i < list[num].size(); i++) {
		if (!visit[list[num][i]]) {
			visit[list[num][i]] = 1;
			cnt += DFS(list[num][i]);
		}
	}
	C[num] = cnt;
	return cnt;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> R >> Q;

	for (int i = 0; i < N-1; i++) {
		int A, B;
		cin >> A >> B;
		list[A].push_back(B);
		list[B].push_back(A);
	}

	visit[R] = 1;
	DFS(R);

	//cout << "\n";
	for (int i = 0; i < Q; i++) {
		int q;
		cin >> q;
		cout << C[q] << "\n";
	}
    

	return 0;
}