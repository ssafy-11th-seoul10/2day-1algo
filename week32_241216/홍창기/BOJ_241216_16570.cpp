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

int arr[1000000];
int f[1000000];

int main() {
    FASTIO;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    reverse(arr, arr + n);
    int max_f = 0;
    int max_cnt = 1;

    for (int i = 1, j = 0; i < n; i++) {
        while (j > 0 && arr[i] != arr[j]) {
            j = f[j - 1];
        }

        if (arr[i] == arr[j]) {
            j++;
            f[i] = j;
        }

        if (f[i] > max_f) {
            max_f = f[i];
            max_cnt = 1;
        }
        else if (f[i] == max_f) {
            max_cnt++;
        }
    }

    if (max_f == 0) {
        println(-1);
    }
    else {
        printw(max_f);
        println(max_cnt);
    }

    return 0;
}
