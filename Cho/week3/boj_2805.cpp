#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int N, M;
    cin >> N >> M;

    vector<int> height(N);
    
    for(int i=0; i < N; i++)
        cin >> height[i];

    int start, end, result;

    end = *max_element(height.begin(), height.end());

    while(start <= end)
    {
        long long int total = 0;
        int mid;
        mid = (start + end) / 2;

        for(int i=0; i < N; i++)
        {
            if(height[i] > mid)
                total += height[i] - mid;
        }

        if(total < M)
            end = mid - 1;
        else
        {
            result = mid;
            start = mid + 1;
        }
    }
    cout << result;
}