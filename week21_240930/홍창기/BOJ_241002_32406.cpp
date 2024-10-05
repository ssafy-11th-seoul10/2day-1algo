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

    vector<int> a(n);

    for (int &ai : a) {
        cin >> ai;
    }

    vector<int> b(n);

    for (int &bi : b) {
        cin >> bi;
    }

    int aa = a[n - 1] + b[n - 2];
    int bb = b[n - 1] + a[n - 2];

    if (aa < bb) swap(aa, bb);

    for (int i = 0; i < n - 2; i++) {
        aa += max(a[i], b[i]);
        bb += min(a[i], b[i]);
    }

    println(aa - bb);

    return 0;
}
