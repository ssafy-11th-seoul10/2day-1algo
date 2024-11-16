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

    string s;
    cin >> s;

    int max_duck = 0;
    int cur_duck = 0;
    int cnt[4] = { 0 };

    for (char c : s) {
        if (c == 'q') {
            cnt[0]++;
            cur_duck++;
            max_duck = max(max_duck, cur_duck);
        }
        else if (c == 'u') {
            if (cnt[0] == 0) {
                max_duck = -1;
                break;
            }

            cnt[0]--;
            cnt[1]++;
        }
        else if (c == 'a') {
            if (cnt[1] == 0) {
                max_duck = -1;
                break;
            }

            cnt[1]--;
            cnt[2]++;
        }
        else if (c == 'c') {
            if (cnt[2] == 0) {
                max_duck = -1;
                break;
            }

            cnt[2]--;
            cnt[3]++;
        }
        else {
            if (cnt[3] == 0) {
                max_duck = -1;
                break;
            }

            cnt[3]--;
            cur_duck--;
        }
    }

    for (int i = 0; i < 4; i++) {
        if (cnt[i] != 0) {
            max_duck = -1;
        }
    }

    println(max_duck);

    return 0;
}
