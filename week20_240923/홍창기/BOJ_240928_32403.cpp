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

    int n, t;
    cin >> n >> t;

    vector<int> ttt;

    for (int i = 1, ie = sqrt(t); i <= ie; i++) {
        if (t % i != 0) continue;

        ttt.push_back(i);
        int j = t / i;

        if (i != j) {
            ttt.push_back(j);
        }
    }

    sort(all(ttt));
    int ans = 0;

    while (n-- > 0) {
        int a;
        cin >> a;

        int pos = lower_bound(all(ttt), a) - ttt.begin();

        if (pos == size(ttt)) {
            ans += a - t;
        }
        else if (pos > 0) {
            ans += min(ttt[pos] - a, a - ttt[pos - 1]);
        }
    }

    println(ans);

    return 0;
}
