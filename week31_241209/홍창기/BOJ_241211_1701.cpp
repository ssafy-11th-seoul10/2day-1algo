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

int get_max_kmp_failure(string &p) {
    int m = size(p);
    vector<int> f(m, 0);
    int i = 1, j = 0;

    while (i < m) {
        if (p[i] == p[j]) {
            i++;
            j++;
            f[i - 1] = j;
        }
        else {
            if (j == 0) {
                i++;
            }
            else {
                j = f[j - 1];
            }
        }
    }

    return *max_element(all(f));
}

int main() {
    FASTIO;

    string s;
    cin >> s;

    int ans = 0;

    for (int i = 0; i < size(s); i++) {
        string w = s.substr(i);
        ans = max(ans, get_max_kmp_failure(w));
    }

    println(ans);

    return 0;
}
