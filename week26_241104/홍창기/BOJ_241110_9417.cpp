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

int get_gcd(int a, int b) {
    int r = a % b;

    if (r == 0) {
        return b;
    }

    return get_gcd(b, r);
}

int main() {
    FASTIO;

    int n;
    cin >> n;
    cin.ignore();

    while (n-- > 0) {
        string line;
        getline(cin, line);

        stringstream ss(line);
        int x;
        vector<int> numbers;

        while (ss >> x) {
            numbers.push_back(x);
        }

        int ans = 1;

        for (int i = 0; i < size(numbers); i++) {
            for (int j = i + 1; j < size(numbers); j++) {
                ans = max(ans, get_gcd(numbers[i], numbers[j]));
            }
        }

        println(ans);
    }

    return 0;
}
