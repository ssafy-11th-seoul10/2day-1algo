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

int a[30][30];

int main() {
    FASTIO;

    int n, m;
    cin >> n >> m;

    for (int u = 0; u < n; u++) {
        for (int i = 0; i < m; i++) {
            cin >> a[u][i];
        }
    }

    int ans = 0;

    for (int i = 0; i < m; i++) {
        for (int j = i + 1; j < m; j++) {
            for (int k = j + 1; k < m; k++) {
                int res = 0;

                for (int u = 0; u < n; u++) {
                    res += max(a[u][i], max(a[u][j], a[u][k]));
                }

                ans = max(ans, res);
            }
        }
    }

    println(ans);

    return 0;
}
