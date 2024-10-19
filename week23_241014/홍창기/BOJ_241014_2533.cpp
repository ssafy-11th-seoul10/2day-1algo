#include <bits/stdc++.h>

#define FASTIO ios_base::sync_with_stdio(false);cin.tie(NULL);
#define size(v) (int)v.size()
#define all(v) v.begin(),v.end()
#define setw(n, c) cout << setw(n) << setfill(c);
#define setp(n) cout << fixed << setprecision(n);
#define printw(x) cout << (x) << ' ';
#define println(x) cout << (x) << '\n';

#ifdef BOJ
#define BOJTEST(x) ((void)0)
#else
#define BOJTEST(x) cout << "[D] " << #x << ':' << x << '\n'
#endif

using namespace std;
using ll = long long;
using uint = unsigned int;
using ull = unsigned long long;
using ld = long double;
using pii = pair<int, int>;

const double PI = M_PI;

vector<int> adj[1000001];

pii dfs(int cur, int par) {
    pii res = { 0, 1 };

    for (int nxt : adj[cur]) {
        if (nxt == par) continue;

        pii nxt_res = dfs(nxt, cur);

        res.first += nxt_res.second;
        res.second += min(nxt_res.first, nxt_res.second);
    }

    return res;
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

    pii ans = dfs(1, 0);

    println(min(ans.first, ans.second));

    return 0;
}
