#include <bits/stdc++.h>

#define FASTIO ios_base::sync_with_stdio(false);cin.tie(NULL);
#define size(v) (int)v.size()
#define all(v) v.begin(),v.end()
#define setw(n, c) cout << setw(n) << setfill(c);
#define setp(n) cout << fixed << setprecision(n);
#define printw(x) cout << (x) << ' ';
#define println(x) cout << (x) << '\n';

#ifdef BOJ
#define BOJTEST(x) ((void)0)
#else
#define BOJTEST(x) cout << "[D] " << #x << ':' << x << '\n'
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

    int scores[8];

    for (int i = 0; i < 8; i++) {
        cin >> scores[i];
    }

    int seq[8] = { 0, 1, 2, 3, 4, 5, 6, 7 };
    int ans = 0;

    do {
        bool flag = true;

        for (int i = 0; i < 8; i++) {
            int ii = (i + 1) % 8;
            int iii = (ii + 1) % 8;

            int a = scores[seq[i]];
            int b = scores[seq[ii]];
            int c = scores[seq[iii]];

            if ((a + c) * b < a * c * sqrt(2)) {
                flag = false;
                break;
            }
        }

        if (flag) ans++;
    } while (next_permutation(seq, seq + 8));

    println(ans);

    return 0;
}
