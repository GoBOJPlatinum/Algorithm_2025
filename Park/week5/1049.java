import java.io.*;
import java.util.*;

public class 1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 필요한 기타줄 수
		int M = Integer.parseInt(st.nextToken()); // 브랜드 수

		int minSet = Integer.MAX_VALUE;
		int minSingle = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int setPrice = Integer.parseInt(st.nextToken());
			int singlePrice = Integer.parseInt(st.nextToken());

			minSet = Math.min(minSet, setPrice);
			minSingle = Math.min(minSingle, singlePrice);
		}

		int option1 = ((N + 5) / 6) * minSet; // 모두 세트로
		int option2 = (N / 6) * minSet + (N % 6) * minSingle; // 세트 + 낱개
		int option3 = N * minSingle; // 모두 낱개로

		int result = Math.min(option1, Math.min(option2, option3));
		System.out.println(result);
	}
}