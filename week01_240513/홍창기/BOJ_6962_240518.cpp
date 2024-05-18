#include <bits/stdc++.h>
using namespace std;

#define FASTIO ios_base::sync_with_stdio(false);cin.tie(NULL); // boj_15552.cpp
#define SETPRECISION(n) cout << fixed;cout.precision(n); // boj_1008.cpp
#define SIZE(v) (int)v.size()
#define ALL(v) v.begin(),v.end()
using ll = long long;

struct Point{
    int x, y;

    Point(int x = 0, int y = 0) : x(x), y(y) {}

    Point operator-(const Point &rhs) const {
        return { x - rhs.x, y - rhs.y };
    }

    bool operator<(const Point &rhs) const {
        if (x != rhs.x) return x < rhs.x;
        return y < rhs.y;
    }
};

int n;
Point points[100];

ll get_ccw(const Point &p1, const Point &p2) {
    return (ll) p1.x * p2.y - (ll) p2.x * p1.y;
}

ll get_ccw(const Point &p1, const Point &p2, const Point &p3) {
    return get_ccw(p2 - p1, p3 - p1);
}

struct PointCmpCcwXY{
    bool operator()(Point &p1, Point &p2) {
        ll ccw = get_ccw(points[0], p1, p2);

        if (ccw != 0) return ccw > 0;
        return p1 < p2;
    }
};

double get_dist(const Point &p1, const Point &p2) {
    ll dx = p1.x - p2.x;
    ll dy = p1.y - p2.y;
    return sqrt(dx * dx + dy * dy);
}

vector<Point> make_convex_hull() {
    swap(points[0], *min_element(points, points + n));
    sort(points + 1, points + n, PointCmpCcwXY());
    vector<Point> convex_hull;

    for (int i = 0; i < n; i++) {
        while (SIZE(convex_hull) >= 2) {
            Point back = convex_hull.back();
            convex_hull.pop_back();

            if (get_ccw(convex_hull.back(), back, points[i]) > 0) {
                convex_hull.push_back(back);
                break;
            }
        }

        convex_hull.push_back(points[i]);
    }

    return convex_hull;
}

int main() {
    FASTIO;
    SETPRECISION(2);

    int t;
    cin >> t;

    while (t-- > 0) {
        cin >> n;

        for (int i = 0; i < n; i++) {
            cin >> points[i].x >> points[i].y;
        }

        vector<Point> convex_hull = make_convex_hull();
        double dist_sum = 0;

        for (int i = 0; i < SIZE(convex_hull); i++) {
            int ni = i + 1;
            if (ni == SIZE(convex_hull)) ni = 0;

            dist_sum += get_dist(convex_hull[i], convex_hull[ni]);
        }

        cout << dist_sum << '\n';
    }

    return 0;
}
