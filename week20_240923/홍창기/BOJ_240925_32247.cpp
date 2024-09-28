#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pii = pair<int, int>;

struct Sticky{
    int c, x, h;

    Sticky(int c, int x, int h) : c(c), x(x), h(h) {
    }

    bool operator<(const Sticky &rhs) const {
        return x < rhs.x;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<Sticky> vec;

    for (int i = 0; i < m; i++) {
        int c, x, h;
        cin >> c >> x >> h;

        vec.emplace_back(c, x, h);
    }

    sort(vec.begin(), vec.end());

    int cx = 0, cy = 0;

    for (auto &st : vec) {
        cy -= st.x - cx;
        cx = st.x;

        if (st.c == 0) {
            cy = st.h + 1 > cy ? st.h + 1 : cy;
        }
        else if (cy >= st.h) {
            cout << "adios\n";
            return 0;
        }
    }

    cy -= n - cx;
    cx = n;

    if (cy <= 0) {
        cout << "stay\n";
    }
    else {
        cout << "adios\n";
    }

    return 0;
}
