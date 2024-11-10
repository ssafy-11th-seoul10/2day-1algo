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

int arr[4];

bool solution() {
    sort(arr, arr + 4);

    if (arr[0] == arr[1] && arr[1] == arr[2]) {
        return true;
    }
    if (arr[1] == arr[2] && arr[2] == arr[3]) {
        return true;
    }
    if (arr[0] == arr[1] && arr[2] == arr[3]) {
        return true;
    }
    if (arr[0] + 1 == arr[1] && arr[1] + 1 == arr[2]) {
        return true;
    }
    if (arr[0] + 1 == arr[1] && arr[1] + 1 == arr[3]) {
        return true;
    }
    if (arr[1] + 1 == arr[2] && arr[2] + 1 == arr[3]) {
        return true;
    }

    return false;
}

int main() {
    FASTIO;

    int t;
    cin >> t;

    while (t-- > 0) {
        for (int i = 0; i < 4; i++) {
            string s;
            cin >> s;

            arr[i] = s[0] - '0';

            if (s[1] == 'm') {
                arr[i] += 10;
            }
            else if (s[1] == 'p') {
                arr[i] += 20;
            }
            else {
                arr[i] += 30;
            }
        }

        println(solution() ? ":)" : ":(");
    }

    return 0;
}
