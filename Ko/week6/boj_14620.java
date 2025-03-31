package Ko.week6;

import java.util.*;
import java.io.*;

public class boj_14620 {
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());

        int m= Integer.parseInt(sk.nextToken());

        int[][] land = new int[m][m];
        boolean[][] visited = new boolean[m][m];

        for(int i=0;i<m;i++){
            sk=new StringTokenizer(bf.readLine());
            for(int k=0;k<m;k++){
                land[i][k]=Integer.parseInt(sk.nextToken());
            }
        }

        dfs(m,visited,land,0,0);
        System.out.print(answer);

    }

    public static void dfs(int m,boolean[][] visited,int[][] land,int cnt,int total){
        if(cnt==3){
            answer=Math.min(answer,total);
            return;
        }

        for(int i=1;i<m-1;i++){
            for(int k=1;k<m-1;k++){
                if(!canVisit(i,k,visited)){
                    continue;
                }
                int num=visit(i,k,visited,land);
                dfs(m,visited,land,cnt+1,total+num);
                backtrack(i,k,visited);
            }
        }

    }

    public static boolean canVisit(int row, int colm, boolean[][] visited){
        if(visited[row][colm]||visited[row+1][colm]||visited[row-1][colm]||visited[row][colm+1]||visited[row][colm-1]){
            return false;
        }
        return true;
    }

    public static int visit(int row , int colm, boolean[][] visited ,int[][] land){
        visited[row][colm]=true;
        visited[row+1][colm]=true;
        visited[row-1][colm]=true;
        visited[row][colm+1]=true;
        visited[row][colm-1]=true;

        return land[row][colm]+land[row+1][colm]+land[row-1][colm]+land[row][colm+1]+land[row][colm-1];
    }
    
    public static void backtrack(int row , int colm, boolean[][] visited){
        visited[row][colm]=false;
        visited[row+1][colm]=false;
        visited[row-1][colm]=false;
        visited[row][colm+1]=false;
        visited[row][colm-1]=false;
    }
}
