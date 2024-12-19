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

int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { -1, 1, 0, 0 };
int board[100][100];

int main() {
    FASTIO;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int x0, y0;
        cin >> x0 >> y0;

        for (int x = x0; x < x0 + 10; x++) {
            for (int y = y0; y < y0 + 10; y++) {
                board[x][y] = 1;
            }
        }
    }

    int ans = 0;

    for (int x = 0; x < 100; x++) {
        for (int y = 0; y < 100; y++) {
            if (board[x][y] == 0) continue;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || board[nx][ny] == 0) {
                    ans++;
                }
            }
        }
    }

    println(ans);

    return 0;
}
