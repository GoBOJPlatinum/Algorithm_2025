// 그리디 알고리즘 A와 B
// 두가지 문자로만 이루어진 문자열 두개(S, T)가 주어졌을 때
// S를 T로 바꾸는 게임
// 문자열 뒤에 A추가, 문자열 뒤집고 뒤에 B 추가
// 바꿀 수 있으면 1, 없으면 0
// 만들어야 할 문자열에서부터 반대로 접근

#include <iostream>
#include <algorithm>
using namespace std;

int main() 
{
    ios_base::sync_with_stdio(0); 
    cin.tie(0); 
    cout.tie(0);

    string s, t, tmp;
    cin >> s >> t;

    while(t.length() > s.length())
    {
        char last = t[t.length() - 1]; // t의 마지막 글자 
        t.erase(t.length() - 1, 1); // t의 마지막 글자 제거
        
        if(last == 'B')
            reverse(t.begin(), t.end());


        if(t == s) 
        {
            cout << 1;
            return 0;
        }
    }

    cout << 0;
    return 0;
}