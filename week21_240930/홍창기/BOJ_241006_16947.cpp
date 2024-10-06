#include <bits/stdc++.h>

#define FASTIO ios_base::sync_with_stdio(false);cin.tie(NULL);
#define size(v) (int)v.size()
#define all(v) v.begin(),v.end()
#define setw(n, c) cout << setw(n) << setfill(c);
#define setp(n) cout << fixed << setprecision(n);
#define printw(x) cout << (x) << ' ';
#define println(x) cout << (x) << '\n';

#ifdef BOJ
#define testPrint(x) ((void)0)
#else
#define testPrint(x) cout << "[D] " << #x << ':' << x << '\n'
#endif

using namespace std;
using ll = long long;
using uint = unsigned int;
using ull = unsigned long long;
using ld = long double;
using pii = pair<int, int>;

const double PI = M_PI;

vector<int> adj[3001];
bool visited[3001];
bool in_cycle[3001];
int dist[3001];

int dfs(int cur, int par) {
    for (int nxt : adj[cur]) {
        if (nxt == par) continue;

        if (visited[nxt]) {
            in_cycle[nxt] = true;
            in_cycle[cur] = true;
            return nxt; // 사이클에 속하는 점을 찾음
        }

        visited[cur] = true;
        int res = dfs(nxt, cur);
        visited[cur] = false;

        if (res == -2) {
            return -2; // 모든 탐색 종료
        }
        else if (res != -1) {
            in_cycle[cur] = true;

            if (res == cur) {
                return -2; // 모든 탐색 종료
            }

            return res; // 사이클에 속하는 점을 찾음
        }
    }

    return -1; // 사이클을 아직 찾지 못함
}

void dfs2(int cur, int par, int cur_dist = 0) {
    dist[cur] = cur_dist;

    for (int nxt : adj[cur]) {
        if (nxt == par || in_cycle[nxt]) continue;

        dfs2(nxt, cur, cur_dist + 1);
    }
}

int main() {
    FASTIO;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs(1, -1);

    for (int u = 1; u <= n; u++) {
        if (!in_cycle[u]) continue;

        dfs2(u, -1);
    }

    for (int u = 1; u <= n; u++) {
        printw(dist[u]);
    }

    cout << '\n';

    return 0;
}
