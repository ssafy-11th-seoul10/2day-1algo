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
const int CLOCK_SIZE = 360000;

int s[CLOCK_SIZE * 2];
int p[CLOCK_SIZE];
int f[CLOCK_SIZE];

void kmp_failure() {
    int m = CLOCK_SIZE;
    int i = 1, j = 0;

    while (i < m) {
        if (p[i] == p[j]) {
            i++;
            j++;
            f[i - 1] = j;
        }
        else {
            if (j == 0) {
                i++;
            }
            else {
                j = f[j - 1];
            }
        }
    }
}

bool kmp() {
    kmp_failure();

    int n = CLOCK_SIZE * 2;
    int m = CLOCK_SIZE;
    int i = 0, j = 0;

    while (i < n) {
        if (s[i] == p[j]) {
            i++;
            j++;

            if (j == m) {
                return true;
            }
        }
        else {
            if (j == 0) {
                i++;
            }
            else {
                j = f[j - 1];
            }
        }
    }

    return false;
}

int main() {
    FASTIO;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;

        s[a] = 1;
        s[a + CLOCK_SIZE] = 1;
    }

    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;

        p[a] = 1;
    }

    if (kmp()) {
        println("possible");
    }
    else {
        println("impossible");
    }

    return 0;
}
