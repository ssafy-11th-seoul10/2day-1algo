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

int a[10001], b[10001];

int main() {
    FASTIO;

    int n, m, k;
    cin >> n >> m >> k;

    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }

    for (int i = 1; i <= m; i++) {
        cin >> b[i];
    }

    int a_sum = 0;
    int b_sum = 0;

    for (int i = 1; i <= n; i++) {
        a_sum += a[i];
    }

    for (int i = 1; i <= m; i++) {
        b_sum += b[i];
    }

    int cnt = min(a_sum, b_sum);
    ll cost = 0;
    int cnt_to_add = cnt;

    for (int i = 1; i <= n; i++) {
        cost += i * min(a[i], cnt_to_add);
        cnt_to_add -= a[i];

        if (cnt_to_add <= 0) break;
    }

    cnt_to_add = cnt;

    for (int i = 1; i <= m; i++) {
        cost += i * min(b[i], cnt_to_add);
        cnt_to_add -= b[i];

        if (cnt_to_add <= 0) break;
    }

    printw(cnt);
    println(cost);

    return 0;
}
