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

int visited[1000000];
int p;

int calc(int a) {
    int res = 0;
    string s = to_string(a);

    for (char c : s) {
        int d = c - '0';
        int dp = d;

        for (int i = 1; i < p; i++) {
            dp *= d;
        }

        res += dp;
    }

    return res;
}

int main() {
    FASTIO;

    int a;
    cin >> a >> p;

    visited[a] = 1;
    int i = 1;

    while (true) {
        i++;
        a = calc(a);

        if (visited[a] != 0) {
            println(visited[a] - 1);
            break;
        }

        visited[a] = i;
    }

    return 0;
}
