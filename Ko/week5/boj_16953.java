import java.util.*;
import java.io.*;
public class boj_16953 {
    public static void main(String[] args) throws IOException{ 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());
        
        long a = Long.parseLong(sk.nextToken());
        long b = Long.parseLong(sk.nextToken());


        long j=dfs(a,b,1);

        if(j==Long.MAX_VALUE){
            System.out.print(-1);
        }else{
            System.out.print(j);
        }
    }

    public static long dfs(long a, long b, long idx){

        if(a==b){
            return idx;
        }else if(a>b){
            return Long.MAX_VALUE;
        }

        return Math.min(dfs(a*2,b,idx+1),dfs(a*10+1,b,idx+1));
    }
}
