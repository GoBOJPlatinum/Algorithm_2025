package Algorithm_2025.Ko.week7;

import java.util.*;
import java.io.*;

public class boj_15650 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(sk.nextToken());
        int m=Integer.parseInt(sk.nextToken());

        dfs(n,m,0,1,"");
    }

    public static void dfs(int n,int m,int cnt,int idx,String k){
        if(m==cnt){
            System.out.println(k);
            return;
        }

        if(idx>n){
            return;
        }
        for(int i=idx;i<=n;i++){
            dfs(n,m,cnt+1,i+1,k+String.valueOf(i)+" ");
        }
    }
}
