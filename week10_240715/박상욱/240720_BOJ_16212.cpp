#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

vector<int> v;

int main(){
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int N;
    
    cin >> N;
    for(int i=0;i<N;i++){
        int num;
        cin >> num;
        v.push_back(num);
    }
    
    sort(v.begin(),v.end());
    
    for(int i=0;i<N;i++){
        cout << v[i] << " ";
    }
    
    return 0;
}