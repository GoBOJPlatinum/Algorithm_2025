import java.util.*;
import java.io.*;

class boj_11047{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());
        int answer=0;

        int n = Integer.parseInt(sk.nextToken());
        int m = Integer.parseInt(sk.nextToken());

        int[] money = new int[n];
        for(int i=0;i<n;i++){
            sk = new StringTokenizer(bf.readLine());
            money[i]=Integer.parseInt(sk.nextToken());
        }

    
        for(int i=money.length-1;i>=0;i--){
            if(m/money[i]>0){
                answer+=m/money[i];
                m=m-money[i]*(m/money[i]);
            }
            if(m==0)break;
        }
        
        System.out.print(answer);
    }
}