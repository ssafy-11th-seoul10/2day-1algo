#include <iostream>
using namespace std;

int main() {
	int a, b; cin >> a >> b;
	bool f1 = false, f2 = false;
	if(a == 1 || a == 3 || a == 4) f1 = true;
	if(b == 1 || b == 3 || b == 4) f2 = true;
	if(f1 && f2) cout << "=";
	else if(f1 && !f2) cout << "<";
	else if(!f1 && f2) cout << ">";
	else if(a == b) cout << "=";
	else if(a == 0){
		if(b == 2){
			cout << ">";
		}
		else if(b == 5){
			cout << "<";
		}
	}
	else if(a == 2){
		if(b == 0){
			cout << "<";
		}
		else if(b == 5){
			cout << ">";
		}
	}
	else if(a == 5){
		if(b == 0){
			cout << ">";
		}
		else if(b == 2){
			cout << "<";
		}
	}
}
