package Algorithm_2025.Ko.week2;

import java.io.*;
import java.util.*;
public class boj_1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] hw = new int[n][2];

        for(int i=0;i<n;i++){
            StringTokenizer sk = new StringTokenizer(bf.readLine());
            hw[i][0]=Integer.parseInt(sk.nextToken());
            hw[i][1]=Integer.parseInt(sk.nextToken());    
        }

        Arrays.sort(hw,(o1,o2)->{
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });

        int count=0;
        int finish=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(hw[i][1]<finish){
                finish=hw[i][1];
            }else if(hw[i][0]>=finish){
                count++;
                finish=hw[i][1];
            }   
        }
        count ++;
        System.out.print(count);

        
    }
}
