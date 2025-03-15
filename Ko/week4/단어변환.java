package Algorithm_2025.Ko.week4

import java.util.*;
class 단어변환환 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int[] visited = new int[words.length];
        bfs(begin,words,visited);
        
        for(int i = 0;i<words.length;i++){
            if(target.equals(words[i])){
                answer = visited[i];
                break;
            }else answer = 0; 
        }
        return answer;
    }
    
    public void bfs(String begin , String[] words , int[] visited){
        Queue<String> que = new LinkedList<>();
        que.offer(begin);
        
        while(!que.isEmpty()){
            String current = que.poll();
            int index = -1;
            for(int i=0;i<words.length;i++){
                if(current.equals(words[i])){
                    index = i;
                }
            }
            
            for(int i=0;i<words.length;i++){
                int k = 0;
                for(int j=0; j<current.length();j++){
                    if(current.charAt(j)==words[i].charAt(j)){
                        k++;
                    }
                }
                
                if(visited[i]==0&&k==current.length()-1){
                    que.offer(words[i]);
                    if(index==-1){
                        visited[i]=1;
                    }else{
                        visited[i]=visited[index]+1;
                    }
                }
            }
        }
    }
}