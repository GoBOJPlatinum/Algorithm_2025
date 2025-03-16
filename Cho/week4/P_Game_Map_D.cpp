// BFS
// 게임 맵 최단거리 
// 게임에 벽(0)과 길(1)이 있어서 상대 진영까지 최단거리를 구하는 문제

#include <vector>
#include <queue>
#include <iostream>
// #include<bits/stdc++.h>
using namespace std;

int dy[] = {-1,0,1,0}; // 상, 우, 하, 좌 이동을 위한 y 좌표 변화량
int dx[] = {0,1,0,-1}; // 상, 우, 하, 좌 이동을 위한 x 좌표 변화량

int BFS(vector<vector<int>> &maps)
{
    queue<pair<int,int>> q;
    int n = maps.size(); // 행
    int m = maps[0].size(); // 열
    vector<vector<int>> table(n,vector<int>(m,0)); // 방문한 위치와 거리를 기록하는 테이블
    
    q.push({0,0}); // 시작위치
    table[0][0] = 1; // 초기화

    while(q.size())
    {
        pair<int,int> current = q.front();
        q.pop();
        for(int i = 0; i < 4; i++)
        { 
            int ny = current.first + dy[i];
            int nx = current.second + dx[i];

            // 맵 범위를 벗어나거나, 벽을 만나거나, 이미 방문한 위치는 무시
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || maps[ny][nx] == 0 || table[ny][nx]) 
                continue;
            
            table[ny][nx] = table[current.first][current.second] + 1; // 거리 업데이트
            q.push({ny,nx}); // 새 위치를 큐에 삽입
        }            
    }
    // 목표 지점에 도달한 경우 거리 반환, 그렇지 않으면 -1 반환
    return table[n - 1][m - 1] > 0 ? table[n - 1][m - 1] : -1;
}


int solution(vector<vector<int> > maps)
{
    int answer = BFS(maps);
    return answer;
}