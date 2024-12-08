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

// 확장된 유클리드 호제법을 이용하여
// a * x + b * y = gcd(a, b)를 만족하는 gcd(a, b)와 x와 y를 구한다.
vector<ll> get_eed(ll a, ll b) {
    ll r0 = a, r1 = b;
    ll s0 = 1, s1 = 0;
    ll t0 = 0, t1 = 1;

    while (r1 > 0) {
        ll q = r0 / r1;
        ll r2 = r0 - q * r1;
        ll s2 = s0 - q * s1;
        ll t2 = t0 - q * t1;
        r0 = r1; r1 = r2;
        s0 = s1; s1 = s2;
        t0 = t1; t1 = t2;
    }

    return { r0, s0, t0 }; // gcd(a, b)와 x와 y
}

// 확장된 유클리드 호제법을 이용하여 모듈로 곱셈 역원을 구한다.
// 즉, 주어진 n과 a에 대하여 a * b = 1 (mod n)을 만족하는 b를 구한다.
// n과 a가 서로소가 아닐 경우, 모듈로 곱셈 역원이 존재하지 않으므로 -1을 반환한다.
ll get_eed_inv(ll n, ll a) {
    vector<ll> eed = get_eed(n, a);

    if (eed[0] != 1) {
        return -1;
    }

    ll b = eed[2];

    while (b < 0) {
        b += n;
    }

    return b;
}

int main() {
    FASTIO;

    ll n, a;
    cin >> n >> a;

    printw(n - a);
    println(get_eed_inv(n, a));

    return 0;
}
