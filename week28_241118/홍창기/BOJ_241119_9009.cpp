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

int f[46] = { 0, 1, 1 };

int main() {
    FASTIO;

    for (int i = 3; i <= 45; i++) {
        f[i] = f[i - 2] + f[i - 1];
    }

    int t;
    cin >> t;

    while (t-- > 0) {
        int n;
        cin >> n;

        vector<int> ans;

        while (n > 0) {
            int idx = upper_bound(f, f + 46, n) - f;
            int k = f[idx - 1];
            ans.push_back(k);
            n -= k;
        }

        for (auto it = ans.rbegin(); it != ans.rend(); it++) {
            printw(*it);
        }

        cout << '\n';
    }

    return 0;
}
