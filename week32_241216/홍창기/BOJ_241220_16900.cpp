// Solve 2024-12-20

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

int get_kmp_failure(string &p) {
    int m = size(p);
    vector<int> f(m, 0);

    for (int i = 1, j = 0; i < m; i++) {
        while (j > 0 && p[i] != p[j]) {
            j = f[j - 1];
        }

        if (p[i] == p[j]) {
            j++;
            f[i] = j;
        }
    }

    return f.back();
}

int main() {
    FASTIO;

    string s;
    ll k;
    cin >> s >> k;

    ll failure = get_kmp_failure(s);
    ll cnt_repeat = size(s) - failure;

    println(failure + cnt_repeat * k);

    return 0;
}
