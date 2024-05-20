#include<iostream>

using namespace std;

int main(){
    
    int N;
    cin >> N;
    
    int cnt= 0;
    
    int s=1,e;
    int temp = 0;


    for(int i=1;i<=N;i++){
        e = i;
        temp += e;
        
        if(temp==N)cnt++;
        
        while(temp>N){
            temp -= s;
            s++;
            
            if(temp==N)cnt++;
        }
    }
    
    cout << cnt << "\n";
    
    return 0;
}