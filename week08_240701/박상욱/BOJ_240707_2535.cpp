#include <bits/stdc++.h>

using namespace std;

struct Student {
    int c, n, s;
};

bool compare(Student &s1, Student &s2){
    return s1.s > s2.s;
}

vector<Student> st;
int num[101] = { 0, };

int main() {
	
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

    int N;
    cin >> N;

    for (int i = 1; i <= N; i++) {
        int c, n, s;
        cin >> c >> n >> s;
        st.push_back({ c, n, s });
    }

    sort(st.begin(), st.end(),compare);

    int cnt = 0;
    for (int i = 0; i < N; i++) {
        if (num[st[i].c] >= 2)continue;

        cout << st[i].c << " " << st[i].n << "\n";
        num[st[i].c]++;
        cnt++;

        if (cnt == 3)break;
    }
	
	return 0;
}

