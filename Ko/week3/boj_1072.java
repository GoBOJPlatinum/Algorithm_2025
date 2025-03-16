package Algorithm_2025.Ko.week3;
import java.util.*;
import java.io.*;

public class boj_1072{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());

        long X = Integer.parseInt(sk.nextToken());
        long Y = Integer.parseInt(sk.nextToken());

        long Pwin = Y*100/X;

        if(Pwin==99||Pwin==100) {
            System.out.println(-1);
            return ;
        }

        long left=0;
        long right=X;
        long mid = 0;
        int answer = 0;
        while(left<=right){
            mid = (left+right)/2;
            long NPwin = (Y+mid)*100/(X+mid);

            if(NPwin>Pwin){
                answer=(int)mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        System.out.print(answer);
    }
}