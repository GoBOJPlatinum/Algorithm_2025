package Algorithm_2025.Ko.week7;

import java.util.*;
import java.io.*;
public class boj_14501 {
    static int answer=0;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(sk.nextToken());

        arr = new int[n][2];
        
        for(int i=0;i<n;i++){
            sk=new StringTokenizer(bf.readLine());
            arr[i][0]=Integer.parseInt(sk.nextToken());
            arr[i][1]=Integer.parseInt(sk.nextToken());
        }
        
        dfs(0,0,n);

        System.out.print(answer);
    }
    public static void dfs(int idx,int cnt ,int n){
        if(idx>=n){
            answer=Math.max(answer,cnt);
            return;
        }

   
        if(idx+arr[idx][0]>n){
            dfs(idx+arr[idx][0],cnt,n);
        }else{
            dfs(idx+arr[idx][0],cnt+arr[idx][1],n);
        }

        dfs(idx+1,cnt,n);
    }
}
