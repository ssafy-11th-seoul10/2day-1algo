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

int n;
int a[11];
int op[4];
int max_val = -1000000001;
int min_val = 1000000001;

void recur(int depth, int val) {
    if (depth >= n) {
        max_val = max(max_val, val);
        min_val = min(min_val, val);
        return;
    }

    if (op[0] > 0) {
        op[0]--;
        recur(depth + 1, val + a[depth]);
        op[0]++;
    }

    if (op[1] > 0) {
        op[1]--;
        recur(depth + 1, val - a[depth]);
        op[1]++;
    }

    if (op[2] > 0) {
        op[2]--;
        recur(depth + 1, val * a[depth]);
        op[2]++;
    }

    if (op[3] > 0) {
        op[3]--;
        recur(depth + 1, val / a[depth]);
        op[3]++;
    }
}

int main() {
    FASTIO;

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    for (int i = 0; i < 4; i++) {
        cin >> op[i];
    }

    recur(1, a[0]);

    println(max_val);
    println(min_val);

    return 0;
}
