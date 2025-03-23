import java.io.*;
import java.util.*;

public class 16953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long start = Long.parseLong(st.nextToken());
		long fin = Long.parseLong(st.nextToken());

		int count = 1;

		while (fin != start){
			
			// 만약 fin이 start보다 작아지는 연산이 발생한다면 중단
			if(fin < start){
				count = -1;
				break;
			}


			if (fin % 10 == 1){
				fin = fin - 1;
				fin = fin / 10;
				count += 1;
			}

			else if (fin % 2 == 0){
				fin = fin / 2;
				count += 1;
			}
			
			// 아무런 연산이 불가능 한 경우가 발생하면 중단
			else {
				count = -1;
				break;
			}

		}

		System.out.println(count);

	}
}
