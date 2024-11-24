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

int heights[500000];

int main() {
    FASTIO;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> heights[i];
    }

    stack<pii> stck;
    ll ans = 0;

    for (int i = 0; i < n; i++) {
        int cur = heights[i];

        while (!stck.empty() && stck.top().first < cur) {
            ans += stck.top().second;
            stck.pop();
        }

        if (stck.empty()) {
            stck.emplace(cur, 1);
            continue;
        }

        if (stck.top().first == cur) {
            if (size(stck) >= 2) {
                ans++;
            }

            ans += stck.top().second;
            stck.top().second++;
            continue;
        }

        ans++;
        stck.emplace(cur, 1);
    }

    println(ans);

    return 0;
}
