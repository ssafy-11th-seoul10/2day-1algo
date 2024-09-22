#include <bits/stdc++.h>
using namespace std;

#define FASTIO ios_base::sync_with_stdio(false);cin.tie(NULL); // boj_15552.cpp
#define SETPRECISION(n) cout << fixed;cout.precision(n); // boj_1008.cpp
#define SIZE(v) (int)v.size()
#define ALL(v) v.begin(),v.end()
using ll = long long;

bool is_vowel(char c) {
    switch (c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            return true;
    }
    return false;
}

int main() {
    FASTIO;

    const ll MOD = 1000000007;

    int t;
    cin >> t;

    while (t-- > 0) {
        string s;
        cin >> s;

        int i = 0;

        while (i < s.size() && !is_vowel(s[i])) {
            i++;
        }

        if (i == s.size()) {
            cout << -1 << '\n';
            continue;
        }

        ll cnt = 1;
        int cur_len = 1;

        while (i < s.size()) {
            if (is_vowel(s[i])) {
                cnt = cnt * cur_len % MOD;
                cur_len = 1;
            }
            else {
                cur_len++;
            }

            i++;
        }

        cout << cnt << '\n';
    }

    return 0;
}
