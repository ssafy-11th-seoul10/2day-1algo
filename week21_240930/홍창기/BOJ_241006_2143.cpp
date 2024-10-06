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

    int t, n;
    cin >> t >> n;

    vector<int> a(n + 1);

    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        a[i] += a[i - 1];
    }

    int m;
    cin >> m;

    vector<int> b(m + 1);

    for (int i = 1; i <= m; i++) {
        cin >> b[i];
        b[i] += b[i - 1];
    }

    unordered_map<int, int> as;

    for (int i = 1; i <= n; i++) {
        for (int j = i; j <= n; j++) {
            as[a[j] - a[i - 1]]++;
        }
    }

    unordered_map<int, int> bs;

    for (int i = 1; i <= m; i++) {
        for (int j = i; j <= m; j++) {
            bs[b[j] - b[i - 1]]++;
        }
    }

    ll ans = 0;

    for (auto &aa : as) {
        int key = t - aa.first;

        if (bs.find(key) != bs.end()) {
            ans += aa.second * (ll) bs[t - aa.first];
        }
    }

    println(ans);

    return 0;
}
