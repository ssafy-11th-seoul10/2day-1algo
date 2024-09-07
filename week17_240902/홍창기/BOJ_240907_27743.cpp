#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;
using ll = long long;

const int MOD = 1000000007;

ll calc_pow(ll a, ll b) {
    ll res = 1;

    while (b > 0) {
        if (b & 1) {
            res = res * a % MOD;
        }

        a = a * a % MOD;
        b >>= 1;
    }

    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    ll n, m;
    cin >> n >> m;

    if (m == 1) {
        int ans = (calc_pow(2, n) - 1 + MOD) % MOD;
        cout << ans << '\n';
    }
    else {
        int ans = (((calc_pow(2, n + 1) - 2 + MOD) % MOD * m) % MOD - 1 + MOD) % MOD;
        cout << ans << '\n';
    }

    return 0;
}
