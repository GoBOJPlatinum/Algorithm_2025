package Algorithm_2025.Ko.week7;

import java.util.*;
import java.io.*;
public class boj_1759{
    static int n;
    static int m;
    static String[] st;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());

        n= Integer.parseInt(sk.nextToken());
        m= Integer.parseInt(sk.nextToken());

        st = bf.readLine().split(" ");

        Arrays.sort(st);

        dfs(0,0,"");
    }
    
    public static void dfs(int idx, int cnt,String ans){
        if(cnt==n){
            int moem=0;
            int jaem=0;
            for(int i=0;i<ans.length();i++){  
                if(ans.charAt(i)=='a'||ans.charAt(i)=='o'||ans.charAt(i)=='i'||ans.charAt(i)=='e'||ans.charAt(i)=='u'){
                    moem++;
                }else{
                    jaem++;
                };
            }
            if(moem>=1&&jaem>=2){
                System.out.println(ans);
            }
            return;
        }

        for(int i=idx;i<m;i++){
            dfs(i+1,cnt+1,ans+st[i]);            
        }
        return;
    }
}