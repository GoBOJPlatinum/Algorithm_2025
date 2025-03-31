package Ko.week6;


import java.util.*;
import java.io.*;
public class boj_15649 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(sk.nextToken());
        int m = Integer.parseInt(sk.nextToken());
      

        boolean[] visited = new boolean[n+1];
        dfs(n,m,visited,0,"");
    }

    public static void dfs(int n, int m, boolean[] visited , int cnt, String st){
        if(cnt==m){
            System.out.println(st);
        }

        for(int i=1;i<=n;i++){
            if(visited[i]==true){
                continue;
            }
            visited[i]=true;
            dfs(n,m,visited,cnt+1,st+String.valueOf(i)+" ");
            visited[i]=false;
        }
    }  
}
