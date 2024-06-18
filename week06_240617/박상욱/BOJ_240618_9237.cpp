#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(){
    
    vector<int>tree;
    
    int N;
    cin >> N;
    for(int i=0;i<N;i++){
        int temp;
        cin >> temp;
        tree.push_back(temp);
    }
    
    sort(tree.begin(),tree.end());
    reverse(tree.begin(),tree.end());
    
    long long int date = 1;
    long long int ans = 0;
    for(int i=0;i<N;i++){
        ans = (date + tree[i] > ans ? date + tree[i] : ans);
        date++;
    }
    
    cout << ans + 1 << "\n";
    
    return 0;
}