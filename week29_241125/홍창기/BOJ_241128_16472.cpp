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

int cnt[26];

int main() {
    FASTIO;

    int n;
    string s;
    cin >> n >> s;

    int alpha_type_cnt = 0;
    int i = 0;
    int j = 0;
    int ans = 0;

    while (j < size(s)) {
        if (++cnt[s[j] - 'a'] == 1) {
            alpha_type_cnt++;

            while (alpha_type_cnt > n) {
                if (--cnt[s[i] - 'a'] == 0) {
                    alpha_type_cnt--;
                }

                i++;
            }
        }

        j++;

        ans = max(ans, j - i);
    }

    println(ans);

    return 0;
}
