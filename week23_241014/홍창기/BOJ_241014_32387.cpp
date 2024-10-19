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

int arr[1000001];

int main() {
    FASTIO;

    int n, q;
    cin >> n >> q;

    set<int> empty_ports;

    for (int i = 1; i <= n; i++) {
        empty_ports.insert(i);
    }

    for (int qi = 1; qi <= q; qi++) {
        int t, i;
        cin >> t >> i;

        if (t == 1) {
            if (empty_ports.lower_bound(i) == empty_ports.end()) {
                println(-1);
            }
            else {
                int port_num = *empty_ports.lower_bound(i);
                empty_ports.erase(port_num);
                arr[port_num] = qi;
                println(port_num);
            }
        }
        else {
            if (arr[i] == 0) {
                println(-1);
            }
            else {
                println(arr[i]);
                arr[i] = 0;
                empty_ports.insert(i);
            }
        }
    }

    return 0;
}
