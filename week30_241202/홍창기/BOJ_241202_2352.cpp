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

int ports[40000];

int get_lis(int n) {
    vector<int> lis;

    for (int i = 0; i < n; i++) {
        int idx = lower_bound(all(lis), ports[i]) - lis.begin();

        if (idx == size(lis)) {
            lis.push_back(ports[i]);
        }
        else {
            lis[idx] = ports[i];
        }
    }

    return size(lis);
}

int main() {
    FASTIO;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> ports[i];
    }

    println(get_lis(n));

    return 0;
}
