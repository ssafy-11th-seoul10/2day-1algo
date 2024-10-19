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

    int n, m;
    cin >> n >> m;

    vector<Interval> intervals;

    for (int i = 0; i < n; i++) {
        int s, e;
        cin >> s >> e;

        if (s > e) {
            intervals.emplace_back(e, s);
        }
    }

    sort(all(intervals));

    int s = -1;
    int e = -1;
    int reversed_dist = 0;

    for (Interval &interval : intervals) {
        if (e < interval.s) {
            s = interval.s;
            e = interval.e;
            reversed_dist += e - s;
        }
        else {
            if (e < interval.e) {
                reversed_dist += interval.e - e;
                e = interval.e;
            }
        }
    }

    println(m + (ll) reversed_dist * 2);

    return 0;
}
