#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;
using ll = long long;

const int MOD = 1000000007;

int calc_pow(ll a, int b) {
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

    int n;
    cin >> n;

    int ans = (calc_pow(2, n + 2) - 5 + MOD) % MOD;

    cout << ans << '\n';

    return 0;
}
