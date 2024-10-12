// Solve 2024-10-09

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

    if (n & 1) {
        for (int i = 1; i < n; i++) {
            printw(i);
        }

        printw(n * (n + 1) / 2);
        println(n);
    }
    else {
        int i = 1;
        int j = n + 1;

        while (i < j) {
            printw(i);
            printw(j);
            i++;
            j--;
        }

        println(n / 2 + 1);
    }

    return 0;
}
