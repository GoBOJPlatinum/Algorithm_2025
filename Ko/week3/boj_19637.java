package Algorithm_2025.Ko.week3;
import java.util.*;
import java.io.*;
public class boj_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        //칭호 수
        int a = Integer.parseInt(sk.nextToken());
        //전투력 수
        int b = Integer.parseInt(sk.nextToken());


        Map<Integer,String> m = new LinkedHashMap<>();

        for(int i=0;i<a;i++){
            sk=new StringTokenizer(bf.readLine());
            String revel = sk.nextToken();
            int score = Integer.parseInt(sk.nextToken());
            if(!m.containsKey(score)){
                m.put(score,revel);
            }
        }
        
        int[] Aarr = new int[m.size()];

        int idx=0;
        for(int s : m.keySet()){
            Aarr[idx++]=s;
        }

        for(int i=0;i<b;i++){
            int score = Integer.parseInt(bf.readLine());
            int left =0;
            int right=Aarr.length-1;
            int mid =0;
            while(left<right){
                mid = (left+right)/2;

                if(Aarr[mid]==score) break;
                if(Aarr[mid]>score){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            mid = (left+right)/2;
            sb.append(m.get(Aarr[mid])+"\n");
        }
        System.out.print(sb);
    }
}
