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

struct Route {
    int s, e;

    Route(int h, int o) {
        s = h;
        e = o;

        if (s > e) {
            swap(s, e);
        }
    }

    bool operator<(const Route &rhs) const {
        if (e != rhs.e) {
            return e < rhs.e;
        }

        return s < rhs.s;
    }
};

int main() {
    FASTIO;

    int n;
    cin >> n;

    vector<Route> routes;

    for (int i = 0; i < n; i++) {
        int h, o;
        cin >> h >> o;

        routes.emplace_back(h, o);
    }

    int d;
    cin >> d;

    sort(all(routes));

    priority_queue<int, vector<int>, greater<int>> pq_mintop;
    int max_cnt = 0;

    for (Route &route : routes) {
        pq_mintop.push(route.s);

        while (!pq_mintop.empty() && pq_mintop.top() < route.e - d) {
            pq_mintop.pop();
        }

        max_cnt = max(max_cnt, size(pq_mintop));
    }

    println(max_cnt);

    return 0;
}
