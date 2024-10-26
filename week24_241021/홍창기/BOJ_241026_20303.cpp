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

int c[30001];
int parent[30001];
int bag[3000];

void init_parent(int n) {
    for (int u = 1; u <= n; u++) {
        parent[u] = -1;
    }
}

int get_parent_of(int u) {
    if (parent[u] < 0) return u;
    return parent[u] = get_parent_of(parent[u]);
}

void union_parents(int u1, int u2) {
    int pu1 = get_parent_of(u1);
    int pu2 = get_parent_of(u2);

    if (pu1 != pu2) {
        if (parent[pu1] < parent[pu2]) {
            parent[pu1] += parent[pu2];
            parent[pu2] = pu1;
            c[pu1] += c[pu2];
        }
        else {
            parent[pu2] += parent[pu1];
            parent[pu1] = pu2;
            c[pu2] += c[pu1];
        }
    }
}

int main() {
    FASTIO;

    int n, m, k;
    cin >> n >> m >> k;

    init_parent(n);

    for (int u = 1; u <= n; u++) {
        cin >> c[u];
    }

    for (int i = 0; i < m; i++) {
        int u1, u2;
        cin >> u1 >> u2;

        union_parents(u1, u2);
    }

    vector<pii> children_and_candy;

    for (int u = 1; u <= n; u++) {
        if (parent[u] < 0) {
            children_and_candy.emplace_back(-parent[u], c[u]);
        }
    }

    for (int i = 1; i < k; i++) {
        bag[i] = -1;
    }

    for (auto &p : children_and_candy) {
        for (int i = k - 1; i >= p.first; i--) {
            if (bag[i - p.first] == -1) continue;

            bag[i] = max(bag[i], bag[i - p.first] + p.second);
        }
    }

    int max_bag = 0;

    for (int i = 0; i < k; i++) {
        max_bag = max(max_bag, bag[i]);
    }

    println(max_bag);

    return 0;
}
