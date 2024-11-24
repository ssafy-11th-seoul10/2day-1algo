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

int dx[6] = { 0, 0, 0, 0, -1, 1 };
int dy[6] = { 0, 0, -1, 1, 0, 0 };
int dz[6] = { -1, 1, 0, 0, 0, 0 };
bool visited[5][5][5];

void init_visited() {
    for (int x = 0; x < 5; x++) {
        for (int y = 0; y < 5; y++) {
            for (int z = 0; z < 5; z++) {
                visited[x][y][z] = false;
            }
        }
    }
}

int main() {
    FASTIO;

    int t;
    cin >> t;

    while (t-- > 0) {
        int p;
        cin >> p;

        string s;
        cin >> s;

        init_visited();
        visited[0][0][0] = true;
        int ans = 6;
        int break_point = -1;

        for (int i = 2; i <= p; i++) {
            cin >> s;

            if (ans == -1) continue;

            stringstream ss(s);
            getline(ss, s, ','); int x = stoi(s);
            getline(ss, s, ','); int y = stoi(s);
            getline(ss, s, ','); int z = stoi(s);

            if (visited[x][y][z]) {
                ans = -1;
                break_point = i;
                continue;
            }

            visited[x][y][z] = true;
            int adj_cnt = 0;

            for (int d = 0; d < 6; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nz = z + dz[d];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5) {
                    continue;
                }

                if (visited[nx][ny][nz]) {
                    adj_cnt++;
                }
            }

            if (adj_cnt == 0) {
                ans = -1;
                break_point = i;
                continue;
            }

            ans += 6 - adj_cnt * 2;
        }

        if (ans == -1) {
            printw("NO");
            println(break_point);
        }
        else {
            println(ans);
        }
    }

    return 0;
}
