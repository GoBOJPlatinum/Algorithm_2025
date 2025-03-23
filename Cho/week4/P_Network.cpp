// DFS
// 네트워크의 개수를 반환하는 문제
// A-B, B-C가 직접적으로 연결되어 있으면 A-C는 간접적으로 연결되어 있음(동일한 네트워크)

#include <vector>
using namespace std;
 
bool dfs(vector<vector<int>>& computers, int n) 
{
    //이미 순회한 노드라면 리턴(재귀함수 탈출조건)
    if (!computers[n][n])    
        return false;

    computers[n][n] = 0;    //순회했다고 변경하기
    
    //노드수만큼 반복
    for (int i = 0; i < computers.size(); i++) 
    {
        //연결된 노드가 있다면 재귀
        if (computers[n][i])    
            dfs(computers, i);
    }
    return true;
}
 
int solution(int n, vector<vector<int>> computers) 
{
    int answer = 0;
    for (int i = 0; i < n; i++) 
    {
        //순회하지 않은 노드라면 dfs탐색후 answer증가
        if (computers[i][i] && dfs(computers, i))
            answer++;
    }
    return answer;
}