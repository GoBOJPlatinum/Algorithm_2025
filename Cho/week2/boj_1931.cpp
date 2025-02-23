#include <iostream>
#include<vector>
#include<algorithm>

using namespace std;
 
int N,connect,cnt;
 
 
int main() {

    cin >> N;
 
    vector<pair<int, int>> p(N);
 
    for (int i = 0; i < N; i++)
        cin >> p[i].second >> p[i].first;

    sort(p.begin(), p.end());
 
    cout << endl;
 
    for (int i = 0; i < N; i++) 
    {
        if (p[i].second >= connect) 
        {
            connect = p[i].first;
            cnt++;
        }
    }
}
