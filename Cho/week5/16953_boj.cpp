// 그리디 알고리즘 A -> B
// A를 B로 바꾸는데 필요한 연산의 최솟값, 만들 수 없으면 -1
// B -> A 변환으로 (2로 나누고 1를 뗀다)

#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int a, b;
    cin >> a >> b;

    int result = 1;
    while (true)
    {
        if (a == b)
            break;
        else if (a > b)
        {
            result = -1;
            break;
        }

        if (b % 2 == 0) // 2로 나누기
            b /= 2;
        else if (b % 10 == 1) // 1 떼기
            b = (b - 1) / 10;    
        else    //만들 수 없으면 -1
        {
            result = -1;
            break;
        }
        result++;
    }

    cout << result;

    return 0;
}