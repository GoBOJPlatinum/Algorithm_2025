// DFS
// 단어 변환
// 주어진 단어에서 words를 사용해 원하는 단어로 변환하기
// 1번에 하나의 단어만 변형시킬 수 있음

#include <string>
#include <vector>

using namespace std;

int answer{ 100 };

void dfs(string begin, string target, vector<string> words, vector<bool>& useCheck, int cnt = 0) 
{
    // 단어의 사이즈만큼 반복
    for (int i = 0; i < words.size(); i++) 
    {
        // 알파벳끼리 일치여부 초기화
        int count{ 0 };
        // 한글자씩 비교하면서 글자가 다를경우 카운트 증가
        for (int j = 0; j < words[i].length(); j++)
            if (!useCheck[i] && begin[j] != words[i][j])    
                count++;
        // 카운트가 1이라면(한 글자만 다른경우)
        if (count == 1) 
        {
            // 1글자만 다른 단어가 target 단어이고 answer가 지금까지 들어온 깊이+1보다 큰경우 answer 변경
            if (target == words[i] && answer > cnt + 1) 
            {
                answer = cnt + 1;
                return;
            }
            // 단어를 사용했다 체크하고 재귀
            useCheck[i] = true;
            dfs(words[i], target, words, useCheck, cnt + 1);
            // 함수를 나온경우 단어사용여부 해제
            useCheck[i] = false;
        }
    }
}
 
int solution(string begin, string target, vector<string> words) 
{
    vector<bool> useCheck(words.size(), false);

    dfs(begin, target, words, useCheck);
    //answer가 100이면 target까지 갈수없으므로 0을 리턴한다.
    if (answer == 100)   
        return 0;
    
    return answer;
}