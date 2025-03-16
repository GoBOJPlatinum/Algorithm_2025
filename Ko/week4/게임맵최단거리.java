package Algorithm_2025.Ko.week4

import java.util.*;

class 게임맵최단거리 {
    int[] mx = {1,0,-1,0};
    int[] my = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];
        bfs(maps,visited);
        
        answer = visited[maps.length-1][maps[0].length-1];
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
    
    public void bfs(int [][]maps, int[][] visited){
        int x = 0;
        int y = 0;
        visited[x][y]=1;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {x,y});
        
        while(!que.isEmpty()){
            int[] current = que.poll();
            int cx = current[0];
            int cy = current[1];
            
            for(int i=0;i<4;i++){
                int nx = cx + mx[i];
                int ny = cy + my[i];
                
                if(nx<0 || nx >maps.length-1 || ny <0 || ny > maps[0].length-1){
                    continue;
                }
                
                if(visited[nx][ny]==0 && maps[nx][ny]==1){
                    que.offer(new int[]{nx,ny});
                    visited[nx][ny]=visited[cx][cy]+1;
                }
            }
        }
    } 
}