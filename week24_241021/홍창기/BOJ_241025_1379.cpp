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

struct Lecture{
    int idx, s, e;

    Lecture(int idx, int s, int e) : idx(idx), s(s), e(e) {
    }

    bool operator<(const Lecture &rhs) const {
        if (s != rhs.s) return s < rhs.s;
        return e < rhs.e;
    }
};

struct Room{
    int idx, e;

    Room(int idx, int e) : idx(idx), e(e) {
    }

    bool operator<(const Room &rhs) const {
        return e > rhs.e;
    }
};

int answer[100001];

int main() {
    FASTIO;

    int n;
    cin >> n;

    vector<Lecture> lectures;
    priority_queue<Room> rooms;

    for (int i = 0; i < n; i++) {
        int idx, s, e;
        cin >> idx >> s >> e;

        lectures.emplace_back(idx, s, e);
    }

    sort(all(lectures));

    for (Lecture &lecture : lectures) {
        if (rooms.empty() || lecture.s < rooms.top().e) {
            int new_room_idx = size(rooms) + 1;
            answer[lecture.idx] = new_room_idx;
            rooms.emplace(new_room_idx, lecture.e);
        }
        else {
            Room empty_room = rooms.top();
            rooms.pop();
            answer[lecture.idx] = empty_room.idx;
            empty_room.e = lecture.e;
            rooms.push(empty_room);
        }
    }

    println(size(rooms));

    for (int i = 1; i <= n; i++) {
        println(answer[i]);
    }

    return 0;
}
