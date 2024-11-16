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

int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int main() {
    FASTIO;

    int n, m;
    cin >> n >> m;

    vector<string> board(n);

    for (string &row : board) {
        cin >> row;
    }

    int x0, y0;
    cin >> x0 >> y0;
    x0--; y0--;

    int max_moved = 0;
    int max_moved_direction = 0;

    for (int d0 = 0; d0 < 4; d0++) {
        int x = x0;
        int y = y0;
        int d = d0;
        int moved = 1;

        while (true) {
            x += dx[d];
            y += dy[d];

            if (moved >= 1000000) {
                break;
            }

            if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] == 'C') {
                break;
            }

            if (board[x][y] == '/') {
                d = d <= 1 ? 1 - d : 5 - d;
            }
            else if (board[x][y] == '\\') {
                d = 3 - d;
            }

            moved++;
        }

        if (moved > max_moved) {
            max_moved = moved;
            max_moved_direction = d0;
        }
    }

    println("URDL"[max_moved_direction]);
    println(max_moved >= 1000000 ? "Voyager" : to_string(max_moved));

    return 0;
}
