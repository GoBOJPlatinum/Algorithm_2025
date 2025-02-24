package Algorithm_2025.Ko.week2;
import java.io.*;
import java.util.*;
public class boj_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] st = new String[n];

        for(int i=0;i<n;i++){
            st[i]=bf.readLine();
        }

        Arrays.sort(st,(o1,o2)->o1.length()-o2.length());

        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(st[j].length()==st[j-1].length()&&st[j].compareTo(st[j-1])<0){
                    String temp = st[j-1];
                    st[j-1]=st[j];
                    st[j]=temp;
                }
            }
        }

        Set<String> s = new LinkedHashSet();
        for(String a : st){
            s.add(a);
        }

        Iterator iter = s.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
