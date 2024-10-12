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

    unordered_map<string, int> hs;

    while (n-- > 0) {
        int s, t;
        cin >> s >> t;

        string a;

        while (t-- > 0) {
            cin >> a;
            hs[a]++;
        }
    }

    int max_cnt = 0;
    string max_tag;

    for (auto &p : hs) {
        if (p.second > max_cnt) {
            max_cnt = p.second;
            max_tag = p.first;
        }
        else if (p.second == max_cnt) {
            max_tag = "-1";
        }
    }

    println(max_tag);

    return 0;
}
