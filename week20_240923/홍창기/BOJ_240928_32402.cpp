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

    int dx[4] = { 0, -1, 0, 1 };
    int dy[4] = { 1, 0, -1, 0 };

    int xp = 0, yp = 0;
    int xc = 0, yc = -1;
    int d = 0;

    int n;
    cin >> n;

    while (n-- > 0) {
        string cmd;
        cin >> cmd;

        if (cmd == "MR") {
            d = (d + 3) % 4;
            xc = xp - dx[d];
            yc = yp - dy[d];
        }
        else if (cmd == "ML") {
            d = (d + 1) % 4;
            xc = xp - dx[d];
            yc = yp - dy[d];
        }
        else if (cmd == "W") {
            xp += dx[d];
            yp += dy[d];
            xc += dx[d];
            yc += dy[d];
        }
        else if (cmd == "A") {
            int dd = (d + 1) % 4;
            xp += dx[dd];
            yp += dy[dd];
            xc += dx[dd];
            yc += dy[dd];
        }
        else if (cmd == "S") {
            int dd = (d + 2) % 4;
            xp += dx[dd];
            yp += dy[dd];
            xc += dx[dd];
            yc += dy[dd];
        }
        else if (cmd == "D") {
            int dd = (d + 3) % 4;
            xp += dx[dd];
            yp += dy[dd];
            xc += dx[dd];
            yc += dy[dd];
        }

        cout << xp << ' ' << yp << ' ' << xc << ' ' << yc << '\n';
    }

    return 0;
}
