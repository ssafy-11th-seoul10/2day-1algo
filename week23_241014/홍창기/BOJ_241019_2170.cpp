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

struct Interval{
    int s, e;

    Interval(int s, int e) : s(s), e(e) {}

    bool operator<(const Interval &rhs) const {
        if (s != rhs.s) {
            return s < rhs.s;
        }

        return e < rhs.e;
    }
};

int main() {
    FASTIO;

    int n;
    cin >> n;

    vector<Interval> intervals;

    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;

        intervals.emplace_back(x, y);
    }

    sort(all(intervals));

    int s = intervals[0].s;
    int e = intervals[0].e;
    int ans = 0;

    for (int i = 1; i < n; i++) {
        if (e < intervals[i].s) {
            ans += e - s;
            s = intervals[i].s;
            e = intervals[i].e;
        }
        else {
            e = max(e, intervals[i].e);
        }
    }

    ans += e - s;
    println(ans);

    return 0;
}
