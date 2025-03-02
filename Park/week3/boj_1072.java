import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1072 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long X = Long.parseLong(input[0]); // 총 게임 수
        long Y = Long.parseLong(input[1]); // 이긴 게임 수

        long Z = (Y * 100) / X; // 현재 승률

        // 승률이 변하지 않는다면 -1 출력
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }
        
        // 추가 승히 횟수 최소 값 0 , 최대 x번 까지 이길 수 있다고 가정
        // 승률을 올리기 위해선 최대 x번 까지 이겨야 할 극단적인 경우가 있음. 따라서 x는 right
        long left = 0, right = X, answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long newZ = ((Y + mid) * 100) / (X + mid);

            if (newZ > Z) { // 승률이 증가하면 mid를 줄여야 함
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
