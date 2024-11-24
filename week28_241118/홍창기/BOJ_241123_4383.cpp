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

int arr[3000];
bool visited[3000];

void init_visited(int n) {
    for (int i = 1; i < n; i++) {
        visited[i] = false;
    }
}

int main() {
    FASTIO;

    int n;

    while (cin >> n) {
        init_visited(n);

        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }

        bool ans = true;

        for (int i = 1; i < n; i++) {
            int diff = abs(arr[i] - arr[i - 1]);

            if (diff == 0 || diff >= n || visited[diff]) {
                ans = false;
                break;
            }

            visited[diff] = true;
        }

        println(ans ? "Jolly" : "Not jolly");
    }

    return 0;
}
