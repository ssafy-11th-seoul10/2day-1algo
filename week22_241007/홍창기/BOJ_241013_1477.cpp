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

int main() {
    FASTIO;

    int n, m, l;
    cin >> n >> m >> l;

    vector<int> positions(n + 2);
    positions[n + 1] = l;

    for (int i = 1; i <= n; i++) {
        cin >> positions[i];
    }

    sort(all(positions));

    vector<int> dists(n + 1);

    for (int i = 1; i <= n + 1; i++) {
        dists[i - 1] = positions[i] - positions[i - 1];
    }

    int d_low = 0; // false
    int d_high = l; // true

    while (d_low + 1 < d_high) {
        int d_mid = (d_low + d_high) / 2;
        int cnt = 0;

        for (int &dist : dists) {
            cnt += (dist - 1) / d_mid;
        }

        if (cnt <= m) {
            d_high = d_mid;
        }
        else {
            d_low = d_mid;
        }
    }

    println(d_high);

    return 0;
}
