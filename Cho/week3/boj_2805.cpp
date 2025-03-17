#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
// 나무자르기 -> 원하는 m를 맞추기 위해 절단기 높이 정하는 방식
int main()
{
    int N, M;
    cin >> N >> M; // N 나무 개수, M 필요한 나무 길이

    vector<int> height(N); // 나무들의 높이 저장하는 벡터

    for(int i=0; i < N; i++)
        cin >> height[i];

    int start, end, result;

    end = *max_element(height.begin(), height.end()); // 가장 높은 나무의 높이를 end로 설정

    while(start <= end)
    {
        long long int total = 0;
        int mid;
        mid = (start + end) / 2; // 0~end(가장 높은 나무의 높이)의 중간 값을 mid로 놓고 이진 탐색

        for(int i=0; i < N; i++)
        {
            if(height[i] > mid) // 중간 높이보다 높이가 높을 때 잘리는 나무의 길이를 total에 더해줌
                total += height[i] - mid;
        }

        if(total < M) // 나무가 아직 부족하므로 mid -1한 값을 end로 설정(범위을 조금씩 좁혀나가기)
            end = mid - 1;
        else // 반대로 더 높은 mid가 있을 수 있으므로 start값을 mid +1로 설정
        {
            result = mid; //절단기 최대 높이을 갱신해줌
            start = mid + 1;
        }
    }
    cout << result;
}