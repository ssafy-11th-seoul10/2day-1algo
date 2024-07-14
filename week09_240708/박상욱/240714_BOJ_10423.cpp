#include <bits/stdc++.h>

using namespace std;

int parent[1001] = { 0, };

int getParent(int x) {
	if (parent[x] == x)return x;
	else return parent[x] = getParent(parent[x]);
}

int find(int a, int b) {
	a = getParent(a);
	b = getParent(b);

	if (a == b) {
		return 1;
	}
	else return 0;
}

void unionParent(int a,int b){
	a = getParent(a);
	b = getParent(b);

	if (a > b) {
		parent[b] = a;
	}
	else
	{
		parent[a] = b;
	}
}

struct Edge {
	int u, v, w;
};

int N, M, K;

struct compare {

	bool operator ()(Edge& e1, Edge& e2) {
		return e1.w > e2.w;
	}

};

priority_queue<Edge, vector<Edge>, compare>pq;

int main() {
	
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> N >> M >> K;

	for (int i = 1; i <= N; i++) {
		parent[i] = i;
	}

	for (int i = 0; i < K; i++) {
		int num;
		cin >> num;
		parent[num] = 0;
	}

	for (int i = 0; i < M; i++) {
		int u, v, w;
		cin >> u >> v >> w;

		pq.push({ u,v,w });
	}

	long long int ans = 0;

	while (!pq.empty()) {
		int u, v, w;
		u = pq.top().u;
		v = pq.top().v;
		w = pq.top().w;

		pq.pop();

		if (!find(u, v)) {
			unionParent(u, v);
			ans += w;
		}
	}

	cout << ans << "\n";


   
	return 0;
}

