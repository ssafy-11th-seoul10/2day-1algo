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

    int t;
    cin >> t;

    while (t-- > 0) {
        string s;
        cin >> s;

        int ans = 3;

        if (s[0] == 'l' || s[0] == 'o') {
            ans = min(ans, 2);
        }

        if (size(s) >= 2) {
            if (s[1] == 'l') {
                ans = min(ans, 2);

                if (s[0] == 'l' || s[0] == 'o') {
                    ans = min(ans, 1);
                }
            }
            else if (s[1] == 'o') {
                ans = min(ans, 2);

                if (s[0] == 'l') {
                    ans = min(ans, 1);
                }
            }
        }


        for (int i = 2; i < size(s); i++) {
            if (s[i] == 'l') {
                ans = min(ans, 2);

                if (s[i - 1] == 'l') {
                    ans = min(ans, 1);
                }
                else if (s[i - 1] == 'o') {
                    ans = min(ans, 1);

                    if (s[i - 2] == 'l') {
                        ans = 0;
                    }
                }

                if (s[i - 2] == 'l') {
                    ans = min(ans, 1);
                }
            }
            else if (s[i] == 'o') {
                ans = min(ans, 2);

                if (s[i - 1] == 'l') {
                    ans = min(ans, 1);
                }
            }
        }

        println(ans);
    }

    return 0;
}
