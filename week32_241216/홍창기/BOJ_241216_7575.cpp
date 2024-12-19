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

vector<int> get_kmp_failure(vector<int> &p) {
    int m = size(p);
    vector<int> f(m, 0);

    for (int i = 1, j = 0; i < m; i++) {
        while (j > 0 && p[i] != p[j]) {
            j = f[j - 1];
        }

        if (p[i] == p[j]) {
            j++;
            f[i] = j;
        }
    }

    return f;
}

bool kmp(vector<int> &s, vector<int> &p) {
    int n = size(s);
    int m = size(p);
    vector<int> f = get_kmp_failure(p);

    for (int i = 0, j = 0; i < n; i++) {
        while (j > 0 && s[i] != p[j]) {
            j = f[j - 1];
        }

        if (s[i] == p[j]) {
            j++;

            if (j == m) {
                return true;
            }
        }
    }

    return false;
}

int main() {
    FASTIO;

    int n, k;
    cin >> n >> k;

    vector<vector<int>> codes;

    for (int i = 0; i < n; i++) {
        int m;
        cin >> m;

        vector<int> code(m);

        for (int &d : code) {
            cin >> d;
        }

        codes.push_back(code);
    }

    for (int i = 0; i <= size(codes[0]) - k; i++) {
        vector<int> part(k);
        vector<int> rpart(k);

        for (int j = 0; j < k; j++) {
            part[j] = codes[0][i + j];
            rpart[j] = part[j];
        }

        reverse(all(rpart));

        bool detected = true;

        for (int j = 1; j < n; j++) {
            if (!kmp(codes[j], part) && !kmp(codes[j], rpart)) {
                detected = false;
                break;
            }
        }

        if (detected) {
            println("YES");
            return 0;
        }
    }

    println("NO");

    return 0;
}
