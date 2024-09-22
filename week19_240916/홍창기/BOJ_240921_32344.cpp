#include <bits/stdc++.h>
using namespace std;

#define FASTIO ios_base::sync_with_stdio(false);cin.tie(NULL); // boj_15552.cpp
#define SETPRECISION(n) cout << fixed;cout.precision(n); // boj_1008.cpp
#define SIZE(v) (int)v.size()
#define ALL(v) v.begin(),v.end()
using ll = long long;

int xl[100000];
int xh[100000];
int yl[100000];
int yh[100000];

int main() {
    FASTIO;

    int r, c, n;
    cin >> r >> c >> n;

    for (int u = 1; u <= n; u++) {
        xl[u] = 100001;
    }

    for (int u = 1; u <= n; u++) {
        yl[u] = 100001;
    }

    for (int i = 0; i < n; i++) {
        int u, x, y;
        cin >> u >> x >> y;

        xl[u] = x < xl[u] ? x : xl[u];
        xh[u] = x > xh[u] ? x : xh[u];
        yl[u] = y < yl[u] ? y : yl[u];
        yh[u] = y > yh[u] ? y : yh[u];
    }

    ll max_area = 0;
    int max_area_idx = 0;

    for (int u = 1; u <= n; u++) {
        if (xl[u] > xh[u] || yl[u] > yh[u]) continue;

        ll area = (ll) (xh[u] - xl[u] + 1) * (yh[u] - yl[u] + 1);

        if (area > max_area) {
            max_area = area;
            max_area_idx = u;
        }
    }

    cout << max_area_idx << ' ' << max_area << '\n';

    return 0;
}
