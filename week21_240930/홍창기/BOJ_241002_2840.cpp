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

    int n, k;
    cin >> n >> k;

    vector<int> v(k);
    vector<char> c(k);

    for (int i = 0; i < k; i++) {
        cin >> v[i] >> c[i];
    }

    string s(n, '?');
    s[0] = c.back();
    int pos = 0;

    for (int i = k - 2; i >= 0; i--) {
        pos = (pos + v[i + 1]) % n;

        if (s[pos] == '?') {
            s[pos] = c[i];
        }
        else if (s[pos] != c[i]) {
            s = "!";
            break;
        }
    }

    if (s[0] != '!') {
        vector<bool> alpha_visited(26);

        for (char c : s) {
            if (c == '?') continue;

            if (alpha_visited[c - 'A']) {
                s = "!";
                break;
            }

            alpha_visited[c - 'A'] = true;
        }
    }

    println(s);

    return 0;
}
