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

int stoi_time(string t) {
    return stoi(t.substr(0, 2)) * 60 + stoi(t.substr(3, 5));
}

void print_time(int t) {
    setw(2, '0'); cout << t / 60 % 24 << ':';
    setw(2, '0'); cout << t % 60 << '\n';
}

struct Depart{
    int section;
    int depart;
    int first_depart;
    int train_num;

    Depart(int section, int depart, int first_depart, int train_num) : section(section), depart(depart), first_depart(first_depart), train_num(train_num) {
    }

    bool operator<(const Depart &rhs) const {
        if (depart != rhs.depart) {
            return depart > rhs.depart;
        }
        if (first_depart != rhs.first_depart) {
            return first_depart > rhs.first_depart;
        }
        return train_num > rhs.train_num;
    }
};

int main() {
    FASTIO;

    int c, h;
    cin >> c >> h;

    priority_queue<Depart> pq;

    for (int i = 0; i < c; i++) {
        int train_num;
        string first_depart_str;
        cin >> train_num >> first_depart_str;
        int first_depart = stoi_time(first_depart_str);
        pq.emplace(1, first_depart, first_depart, train_num);
    }

    for (int i = 0; i < h; i++) {
        int train_num;
        string first_depart_str;
        cin >> train_num >> first_depart_str;
        int first_depart = stoi_time(first_depart_str);
        pq.emplace(4, first_depart, first_depart, train_num);
    }

    int section_time[5] = { 0, 7, 7, 8, 10 };
    int section_arrival[5] = { 0 };
    vector<pii> results;

    while (!pq.empty()) {
        Depart cur = pq.top();
        pq.pop();

        if (cur.depart < section_arrival[cur.section]) {
            pq.emplace(cur.section, section_arrival[cur.section], cur.first_depart, cur.train_num);
            continue;
        }

        int arrival = max(cur.depart, section_arrival[cur.section]) + section_time[cur.section];
        section_arrival[cur.section] = arrival;

        if (cur.train_num % 2 == 1) {
            if (cur.section == 4) {
                results.emplace_back(cur.train_num, arrival);
                continue;
            }

            pq.emplace(cur.section + 1, arrival + 1, cur.first_depart, cur.train_num);
        }
        else {
            if (cur.section == 1) {
                results.emplace_back(cur.train_num, arrival);
                continue;
            }

            pq.emplace(cur.section - 1, arrival + 1, cur.first_depart, cur.train_num);
        }
    }

    sort(all(results));

    for (pii &result : results) {
        print_time(result.second);
    }

    return 0;
}
