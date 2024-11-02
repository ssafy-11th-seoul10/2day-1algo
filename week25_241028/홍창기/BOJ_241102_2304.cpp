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

    vector<pii> columns;

    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;

        columns.emplace_back(x, y);
    }

    sort(all(columns));

    int max_y = -1;
    int max_y_first_idx = -1;
    int max_y_last_idx = -1;

    for (int i = 0; i < n; i++) {
        if (columns[i].second > max_y) {
            max_y = columns[i].second;
            max_y_first_idx = i;
            max_y_last_idx = i;
        }
        else if (columns[i].second == max_y) {
            max_y_last_idx = i;
        }
    }

    int ans = (columns[max_y_last_idx].first - columns[max_y_first_idx].first + 1) * max_y;
    int prev_x = 0;
    int prev_y = 0;

    for (int i = 0; i <= max_y_first_idx; i++) {
        if (prev_y >= columns[i].second) {
            continue;
        }

        ans += (columns[i].first - prev_x) * prev_y;
        prev_x = columns[i].first;
        prev_y = columns[i].second;
    }

    prev_x = 1001;
    prev_y = 0;

    for (int i = n - 1; i >= max_y_last_idx; i--) {
        if (columns[i].second <= prev_y) {
            continue;
        }

        ans += (prev_x - columns[i].first) * prev_y;
        prev_x = columns[i].first;
        prev_y = columns[i].second;
    }

    println(ans);

    return 0;
}
