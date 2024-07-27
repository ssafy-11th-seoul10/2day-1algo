#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

    vector<string> v;
    vector<string> increase;
    vector<string> decrease;

int main(){
    
    int N;
    cin >> N;
    

    for(int i=0;i<N;i++){
        string temp;
        cin >> temp;
        v.push_back(temp);
        increase.push_back(temp);
        decrease.push_back(temp);
    }
    
    sort(increase.begin(), increase.end());
    sort(decrease.begin(),decrease.end());
    reverse(decrease.begin(),decrease.end());
    
    int f1=1,f2=1;
   
    for(int i=0;i<N;i++){
        if(v[i] != increase[i])f1=0;
        if(v[i]!=decrease[i])f2=0;
    }
    
    if(f1)cout << "INCREASING";
    else if(f2)cout << "DECREASING";
    else cout << "NEITHER";
    
    
    
    
    return 0;
}