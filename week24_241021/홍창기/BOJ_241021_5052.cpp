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

struct Trie{
    map<char, Trie*> children;
    bool ended_flag;

    Trie() : ended_flag(false) {
    }

    ~Trie() {
        for (auto it = children.begin(); it != children.end(); it++) {
            delete it->second;
        }
    }

    void insert(string &s, int idx) {
        if (idx == size(s)) {
            ended_flag = true;
            return;
        }

        if (children.find(s[idx]) == children.end()) {
            Trie* child = new Trie;
            children[s[idx]] = child;
        }

        children[s[idx]]->insert(s, idx + 1);
    }

    bool dfs() {
        if (ended_flag && size(children) >= 1) {
            return false;
        }

        for (auto it = children.begin(); it != children.end(); it++) {
            bool res = it->second->dfs();

            if (!res) return false;
        }

        return true;
    }
};

int main() {
    FASTIO;

    int t;
    cin >> t;

    while (t-- > 0) {
        int n;
        cin >> n;

        Trie* root = new Trie;

        while (n-- > 0) {
            string s;
            cin >> s;

            root->insert(s, 0);
        }

        bool ans = root->dfs();
        println(ans ? "YES" : "NO");

        delete root;
    }

    return 0;
}
