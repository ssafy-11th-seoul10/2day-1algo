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

    int q;
    cin >> q;

    ll low = -1000000000000000001;
    ll high = 1000000000000000001;
    int found_idx = -1;
    int paradox_idx = -1;

    for (int qi = 1; qi <= q; qi++) {
        ll x;
        char c;
        cin >> x >> c;

        if (c == '^') {
            low = max(low, x);
        }
        else {
            high = min(high, x);
        }

        if (low + 2 > high) {
            if (paradox_idx == -1) {
                paradox_idx = qi;
            }
        }
        else if (low + 2 == high) {
            if (found_idx == -1) {
                found_idx = qi;
            }
        }
    }

    if (paradox_idx > -1) {
        println("Paradox!");
        println(paradox_idx);
    }
    else if (found_idx > -1) {
        println("I got it!");
        println(found_idx);
    }
    else {
        println("Hmm...");
    }

    return 0;
}
