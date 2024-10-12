// Solve 2024-10-11

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

    int n;
    ll m;
    cin >> n >> m;

    vector<ll> a(n);

    for (ll &ai : a) {
        cin >> ai;
    }

    int ans = 0;
    int cur_len = 1;

    for (int i = 1; i < n; i++) {
        if (abs(a[i - 1] - a[i]) >= m) {
            ans += cur_len / 2;
            cur_len = 0;
        }

        cur_len++;
    }

    ans += cur_len / 2;
    println(ans);

    return 0;
}
