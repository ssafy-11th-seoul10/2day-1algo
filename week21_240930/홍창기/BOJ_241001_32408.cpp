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

vector<int> adj[100001];
bool visited[100001];
vector<int> path;

bool dfs(int cur, int par) {
    if (cur == 1) {
        visited[1] = true;
        path.push_back(1);
        return true;
    }

    for (int nxt : adj[cur]) {
        if (nxt == par) continue;

        if (dfs(nxt, cur)) {
            visited[cur] = true;
            path.push_back(cur);
            return true;
        }
    }

    return false;
}

int dfs2(int cur, int par) {
    int weight = 1;

    for (int nxt : adj[cur]) {
        if (nxt == par) continue;

        weight += dfs2(nxt, cur);
    }

    return weight;
}

int main() {
    FASTIO;

    int n;
    cin >> n;

    for (int i = 1; i < n; i++) {
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs(n, -1);
    vector<int> weights;

    for (int u : path) {
        for (int v : adj[u]) {
            if (visited[v]) continue;

            int weight = dfs2(v, u);
            weights.push_back(weight);
        }
    }

    vector<int> weights_prefix_sum(size(weights));

    if (size(weights) > 0) {
        weights_prefix_sum[0] = weights[0];
    }

    for (int i = 1; i < size(weights); i++) {
        weights_prefix_sum[i] = weights_prefix_sum[i - 1] + weights[i];
    }

    ll ans = 0;

    for (int i = 1; i < size(weights); i++) {
        ans += (ll) weights_prefix_sum[i - 1] * weights[i];
    }

    println(ans);

    return 0;
}
