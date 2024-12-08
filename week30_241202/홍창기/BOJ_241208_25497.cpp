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
    string cmds;
    cin >> n >> cmds;

    int ans = 0;
    int lr = 0;
    int sk = 0;

    for (char &cmd : cmds) {
        if (cmd == 'L') {
            lr++;
        }
        else if (cmd == 'R') {
            lr--;

            if (lr < 0) break;

            ans++;
        }
        else if (cmd == 'S') {
            sk++;
        }
        else if (cmd == 'K') {
            sk--;

            if (sk < 0) break;

            ans++;
        }
        else {
            ans++;
        }
    }

    println(ans);

    return 0;
}
