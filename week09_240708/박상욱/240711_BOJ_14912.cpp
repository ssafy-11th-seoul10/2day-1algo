#include<iostream>

using namespace std;

int main(){
    
    int n,d;
    cin >> n >> d;
    
    int cnt = 0;
    for(int i=1;i<=n;i++){
        int temp = i;
        while(temp > 0){
            if(temp%10==d){
                cnt++;
            }
            temp/=10;
        }
    }
    
    cout << cnt << "\n";
    
    return 0;
}