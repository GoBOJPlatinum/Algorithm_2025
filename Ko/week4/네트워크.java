package Algorithm_2025.Ko.week4

import java.util.*;
class 네트워크 {
    int count=0;
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i<n; i++){
            if(!visited[i]){
                dfs(computers,visited,i);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int[][] computers, boolean[] visited, int index){

        visited[index]= true;
        for(int i=0;i<computers[index].length;i++){
            if(index!=i&&computers[index][i]==1&&!visited[i]){
                dfs(computers,visited,i);
            }
        }
    }
}