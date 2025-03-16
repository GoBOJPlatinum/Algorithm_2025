package Algorithm_2025.Ko.week3;

import java.util.*;
import java.io.*;

public class boj_2805 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());
        int num=Integer.parseInt(sk.nextToken());
        int purpose = Integer.parseInt(sk.nextToken());

        int[] arr = new int[num];
        sk=new StringTokenizer(bf.readLine());
        for(int i=0;i<num;i++){
            arr[i]=Integer.parseInt(sk.nextToken());
        }

        Arrays.sort(arr);

        int left=0;
        int right=arr[num-1];
        int mid =0;
        int answer = 0;

        while(left<=right){
            mid=(left+right)/2;
            long total=0;

            for(int i=arr.length-1;i>=0;i--){
                if(mid>=arr[i]) break;
                total+=arr[i]-mid;
            }

            if(total>=purpose){
                answer =mid;
                left=mid+1;
            }else if(total<purpose){
                right=mid-1;
            }
        }
        System.out.println(answer);
    }
}
