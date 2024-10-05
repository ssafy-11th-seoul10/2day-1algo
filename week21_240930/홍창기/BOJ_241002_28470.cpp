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
    cin >> n;

    vector<int> a(n);

    for (int &ai : a) {
        cin >> ai;
    }

    vector<int> b(n);

    for (int &bi : b) {
        cin >> bi;
    }

    ll ans = 0;

    for (int i = 0; i < n; i++) {
        double ki;
        cin >> ki;

        if (ki >= 1) {
            ans += a[i] * (ll) round(ki * 10) / 10 - b[i];
        }
        else {
            ans += a[i] - b[i] * (ll) round(ki * 10) / 10;
        }
    }

    println(ans);

    return 0;
}
