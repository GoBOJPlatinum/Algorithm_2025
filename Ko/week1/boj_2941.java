import java.io.*;

public class boj_2941 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        // c= ,s= 과 같이 =이 뒤에 등장하므로 역정렬
        StringBuilder sb = new StringBuilder(input).reverse();
        int count = 0;
        
        //전체 탐색하면서 해당 문자가 나오면 i를 증가시키고 count를 증가시킴킴
        for(int i=0;i<sb.length();i++){
            if(i<sb.length()-1 && sb.charAt(i)=='='){
                if(sb.charAt(i+1)=='c'||sb.charAt(i+1)=='s'){
                    count++;
                    i++;
                    continue;
                }else if(i<sb.length()-2 && sb.charAt(i+1)=='z'&& sb.charAt(i+2)=='d'){
                    count++;
                    i=i+2;
                    continue;
                }else{
                    count++;
                    i++;
                    continue;
                }
            }else if(sb.charAt(i)=='-'){
                count++;
                i++;
                continue;
            }else if(i < sb.length()-1 && sb.charAt(i)=='j'&& (sb.charAt(i+1)=='l'||sb.charAt(i+1)=='n')){
                count++;
                i++;
                continue;
            }else{
                count++;
            }
        }
        System.out.println(count);
    }
}
