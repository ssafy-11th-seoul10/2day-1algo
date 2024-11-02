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

bool sieve[1003002];

int main() {
    FASTIO;

    sieve[1] = true;
    vector<int> primes;

    for (int i = 2; i <= 1003001; i++) {
        if (sieve[i]) continue;

        primes.push_back(i);

        for (int j = i + i; j <= 1003001; j += i) {
            sieve[j] = true;
        }
    }

    vector<int> palindrome_primes;

    for (int prime : primes) {
        string s = to_string(prime);
        int i = 0;
        int j = size(s) - 1;
        bool is_palindrome = true;

        while (i < j) {
            if (s[i] != s[j]) {
                is_palindrome = false;
                break;
            }

            i++;
            j--;
        }

        if (is_palindrome) {
            palindrome_primes.push_back(prime);
        }
    }

    int n;
    cin >> n;

    int ans = *lower_bound(all(palindrome_primes), n);
    println(ans);

    return 0;
}
