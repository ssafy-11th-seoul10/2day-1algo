#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

vector<long long int>v;

int main(){
    
    int n;
    
    cin >> n;
    
    for(int i=0;i<n;i++){
        long long int num;
        cin >> num;
        
        long long int temp = 0;
        while(num > 0){
            temp *= 10;
            temp += num%10;
            num/=10;
        }
        
        v.push_back(temp);
    }
    
    sort(v.begin(), v.end());
    
    for(int i=0;i<v.size();i++){
        cout << v[i] << "\n";
    }
    
    return 0;
}