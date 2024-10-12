// Solve 2024-10-12

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

    int n, k;
    string s;
    cin >> n >> k >> s;

    for (char &c : s) {
        if (c == 'A') continue;

        int cnt_to_a = 'Z' - c + 1;

        if (cnt_to_a <= k) {
            k -= cnt_to_a;
            c = 'A';
        }

    }

    if (k > 0) {
        s.back() = (s.back() - 'A' + k) % 26 + 'A';
    }

    println(s);

    return 0;
}
