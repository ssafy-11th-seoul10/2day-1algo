#include <bits/stdc++.h>

#define FASTIO ios_base::sync_with_stdio(false);cin.tie(NULL);
#define size(v) (int)v.size()
#define all(v) v.begin(),v.end()
#define setw(n, c) cout << setw(n) << setfill(c);
#define setp(n) cout << fixed << setprecision(n);
#define printw(x) cout << (x) << ' ';
#define println(x) cout << (x) << '\n';

#ifdef BOJ
#define BOJTEST(x) ((void)0)
#else
#define BOJTEST(x) cout << "[D] " << #x << ':' << x << '\n'
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

    double x1, y1, r1, x2, y2, r2;
    cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

    double dx = x2 - x1;
    double dy = y2 - y1;
    double d = sqrt(dx * dx + dy * dy);

    if (d >= r1 + r2) {
        setp(3);
        println(0.0);
    }
    else if (d <= abs(r1 - r2)) {
        setp(3);
        println(PI * min(r1 * r1, r2 * r2));
    }
    else {
        double theta1 = acos((d * d + r1 * r1 - r2 * r2) / (2 * d * r1));
        double theta2 = acos((d * d + r2 * r2 - r1 * r1) / (2 * d * r2));

        double area1 = r1 * r1 * (theta1 - 0.5 * sin(2 * theta1));
        double area2 = r2 * r2 * (theta2 - 0.5 * sin(2 * theta2));
        double area = area1 + area2;

        setp(3);
        println(area);
    }

    return 0;
}
