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

int arr[200000];

int main() {
    FASTIO;

    int t;
    cin >> t;

    while (t-- > 0) {
        int n;
        cin >> n;

        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }

        bool ans = true;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] <= 0) {
                ans = false;
                break;
            }

            arr[i] -= arr[i - 1] - 1;
        }

        if (arr[n - 1] != 0 && arr[n - 1] != 1) {
            ans = false;
        }

        println(ans ? "YES" : "NO");
    }

    return 0;
}
