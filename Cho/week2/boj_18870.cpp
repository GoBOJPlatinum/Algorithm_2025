#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int N;
    cin >> N;
    vector<int> v(N);

    for (int i = 0; i < N; ++i)
    {
        cin >> v[i];
    }

    vector<int> ans(v);
    sort(ans.begin(), ans.end());
    ans.erase(unique(ans.begin(), ans.end()), ans.end());

    for (const auto& val : v)
    {
        auto it = find(ans.begin(), ans.end(), val);
        cout << distance(ans.begin(), it) << ' ';
    }
}