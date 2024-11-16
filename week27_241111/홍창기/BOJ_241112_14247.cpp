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

int h[100000];
int a[100000];

int main() {
    FASTIO;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> h[i];
    }

    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    vector<pii> a_and_h;

    for (int i = 0; i < n; i++) {
        a_and_h.emplace_back(a[i], h[i]);
    }

    sort(all(a_and_h));

    ll ans = 0;

    for (int i = 0; i < n; i++) {
        ans += a_and_h[i].second + a_and_h[i].first * i;
    }

    println(ans);

    return 0;
}
