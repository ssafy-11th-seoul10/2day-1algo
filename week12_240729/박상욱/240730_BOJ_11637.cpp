#include<iostream>

using namespace std;

int main(){
    
    int T;
    cin >> T;
    
    for(int i=0;i<T;i++){
        int N;
        cin >> N;
        
        int total = 0;
        int M = -1;
        int idx = -1;
        int same = 0;
        for(int i=0;i<N;i++){
            int num;
            cin >> num;
            total += num;
            if(num>M){
                M = num;
                idx = i+1;
                same = 0;
            }
            else if(num==M){
                same = 1;
            }
        }
        
        if(same==1){
            cout << "no winner\n";
        }
        else if(M > total/2){
            cout << "majority winner " << idx << "\n";
        }
        else{
            cout << "minority winner " << idx << "\n";
        }
    }
    
    return 0;
}