#include <iostream>
#include <algorithm>
#include <queue>
#include <string>
#include <vector>

using namespace std;

/*17825*/

struct info {
	int a, b;
};

int score[10];
vector<vector<int>>board(5);
vector<info> loc(4, { 0, 0 }); // 말 위치
vector<bool> isDone(4, false);
int result = 0;
int tempState[10];

void init_board() {
	//정방향
	for (int i = 0; i <= 20; i++) board[0].push_back(i * 2);
	board[0].push_back(-1); // 종료

	// -> 
	board[1].push_back(0);
	for (int i = 1; i <= 3; i++) board[1].push_back(10 + 3 * i);
	board[1].push_back(25);

	// 위로
	board[2].push_back(0);
	for (int i = 1; i <= 2; i++) board[2].push_back(20 + 2 * i);
	board[2].push_back(25);

	// <-
	board[3].push_back(0);
	for (int i = 1; i <= 3; i++) board[3].push_back(29 - 1 * i);
	board[3].push_back(25);

	// 위로
	board[4].push_back(0);
	for (int i = 1; i <= 3; i++) board[4].push_back(25 + 5 * i);
	board[4].push_back(-1); // 종료


}

int lets_move(int n, int dice) {
	int temp = 0;
	int ta = loc[n].a;
	int tb = loc[n].b;
	bool isEnd = false;

	while (dice-- > 0) {
		// 넘어 가거나 같을 경우
		if (board[ta].size() <= tb+1) {
			if (board[ta][tb] == 25) {
				ta = 4;
				tb = 0;
			}
			else {
				ta = board[ta][tb] / 10;
				tb = 0;
			}
		}

		if (board[ta][++tb] == -1) {
			isEnd = true;
			break;
		}
	}
	temp = board[ta][tb];

	if (isEnd) { // 진입할 공간 없음
		loc[n].a = ta;
		loc[n].b = tb;
		return 0;
	}
	
	// 몇 번째에 있는지 확인
	if (ta == 0 && board[ta][tb] % 10 == 0 && board[ta][tb] > 0 && board[ta][tb] < 40 ) {
		ta = board[ta][tb] / 10;
		tb = 0;
	}

	// 같은 위치에 있는 윷 검사
	for (int i = 0; i < 4; i++) {
		// 진입 불가
		if (loc[i].a == ta && loc[i].b == tb) return -1;
		else if (board[loc[i].a][loc[i].b] == 40 && board[ta][tb] == 40) return -1;
	}

	loc[n].a = ta;
	loc[n].b = tb;
	return temp;
}

void lets_play(int c, int sum) {
	if (c == 10) {
		result = max(sum, result);
		
		return;
	}

	for (int i = 0; i < 4; i++) {
		if (board[loc[i].a][loc[i].b] == -1) continue;

		// 이동
		info tempPlayer = loc[i];
		int tempScore = lets_move(i, score[c]);
		
		//cout << "tempScore: " << tempScore << " , loc: " << i << " , [a: " << loc[i].a << " , b: " << loc[i].b << "] \n";
		if (tempScore != -1) { 
			//tempState[c] = tempScore;
			lets_play(c + 1, sum + tempScore); 
		}

		loc[i] = tempPlayer;
	}
}

int main() {
	// board 만들기
	init_board();

	for (int i = 0; i < 10; i++) {
		cin >> score[i];
	}

	lets_play(0, 0);

	cout << result;
}

//if (result ==218) {
//		cout << "find!!!!!\n";
//		for (int i = 0; i < 4; i++) {
//			cout << "i: " << i << " , [ a: " << loc[i].a << " ,b: " << loc[i].b << " ]\n";
//		}
//		for (int i = 0; i < 10; i++) cout << tempState[i] << ' ';
//		cout << '\n';
//	}

	//cout << "result: "<< result << '\n';
	//cout << "============게임 끝==========\n";
