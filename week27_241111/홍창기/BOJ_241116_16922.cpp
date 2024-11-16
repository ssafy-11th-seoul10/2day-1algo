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

    unordered_set<int> hs;

    for (int a = n; a >= 0; a--) {
        for (int b = n - a; b >= 0; b--) {
            for (int c = n - a - b; c >= 0; c--) {
                hs.insert(a * 50 + b * 10 + c * 5 + (n - a - b - c));
            }
        }
    }

    println(size(hs));

    return 0;
}
