// Solve 2024-10-19

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
    setp(13);

    int x, y, d, t;
    cin >> x >> y >> d >> t;

    double z = sqrt(x * x + y * y);

    if (d <= t) {
        println(z);
        return 0;
    }

    int a = (int) floor(z) / d;

    if (a == 0) {
        println(min(z, min(t + d - z, (double) (t * 2))));
        return 0;
    }

    println(min(t * a + z - d * a, (double) (t * (a + 1))));

    return 0;
}
