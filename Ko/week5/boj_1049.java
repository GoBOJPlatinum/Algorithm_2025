import java.util.*;
import java.io.*;
class boj_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(sk.nextToken());
        int m = Integer.parseInt(sk.nextToken());

        int[] package_price = new int[m];
        int[] one_price = new int[m];

        for(int i=0;i<m;i++){
            sk = new StringTokenizer(bf.readLine());
            package_price[i]= Integer.parseInt(sk.nextToken());
            one_price[i]= Integer.parseInt(sk.nextToken());
        }
        
        Arrays.sort(package_price);
        Arrays.sort(one_price);

        int best_package_price=package_price[0];
        int best_one_price = one_price[0];

        if(best_one_price*6<=best_package_price){
            System.out.print(best_one_price*n);
        }else if(best_one_price>=best_package_price){
            if(n%6==0){
                System.out.print(best_package_price*(n/6));
            }else{
                System.out.print(best_package_price*((n/6)+1));
            }
        }else{
            int k = n%6;
            if(k>0){
                if(k*best_one_price<best_package_price){
                    System.out.print(best_package_price*(n/6)+best_one_price*k);
                }else{
                    System.out.print(best_package_price*(n/6+1));
                }
            }else{
                System.out.print(best_package_price*(n/6));
            } 
        }
    }
}