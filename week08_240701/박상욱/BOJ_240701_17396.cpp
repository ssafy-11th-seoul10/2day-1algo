#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>
#include<map>

using namespace std;

#define INF 9e12

int N, M;

struct Edge {
	long long int target, dist;
};

int view[100001] = { 0, };
long long int dist[100001] = {0, };
vector<Edge> node[100001];

struct compare {
	bool operator()(Edge &e1, Edge &e2) {
		return e1.dist > e2.dist;
	}
};

void dijkstra(int start) {
	for (int i = 0; i < N; i++) {
		dist[i] = INF;
	}

	dist[start] = 0;

	priority_queue<Edge, vector<Edge>, compare >pq;

	pq.push({ start, 0 });

	while (!pq.empty()) {
		int current = pq.top().target;
		long long int distance = pq.top().dist;

		pq.pop();

		if (view[current] == 1)continue;

		if (dist[current] >= distance) {
			for (int i = 0; i < node[current].size(); i++) {
				int next = node[current][i].target;
				long long int  nextDist = node[current][i].dist;

				if (nextDist + distance < dist[next] ) {
					dist[next] = nextDist + distance;
					pq.push({ next, dist[next] });
				}
			}
		}
	}

}

int main() {
	
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		cin >> view[i];
	}

	for (int i = 0; i < M; i++) {
		int a, b, t;
		cin >> a >> b >> t;
		node[a].push_back({ b,t });
		node[b].push_back({ a,t });
	}
	
	dijkstra(0);

	if (dist[N - 1] >= INF) {
		dist[N - 1] = -1;
	}

	cout << dist[N-1];

	
	return 0;
}

