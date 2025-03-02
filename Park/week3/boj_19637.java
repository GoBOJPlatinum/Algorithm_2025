import java.io.*;
import java.util.*;

public class boj_19637 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 칭호의 개수, 칭호를 출력해야 하는 캐릭터들의 개수
        int levelCount = Integer.parseInt(st.nextToken());
        int chCount = Integer.parseInt(st.nextToken());

        // 칭호 이름을 저장할 배열
        String[] level = new String[levelCount];
        
        // 칭호별 전투력 상한 값을 저장할 배열
        int[] levelRange = new int[levelCount];
        
        // 입력 데이터 처리 (각 칭호와 전투력)
        for (int i = 0; i < levelCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            level[i] = st.nextToken();
            levelRange[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder(); // ✅ 반복문 내에서 여러 번 출력할 경우 StringBuilder 사용 최적화
        
        for (int i = 0; i < chCount; i++) {
            int power = Integer.parseInt(br.readLine());
            sb.append(bSearch(power, levelCount, levelRange, level)).append("\n");
        }

        System.out.print(sb); // ✅ StringBuilder는 한 번만 출력
    }
    
    // 이진 탐색을 사용하여 적절한 칭호 찾기
    public static String bSearch(int power, int levelCount, int[] levelRange, String[] level) {
        int start = 0;
        int end = levelCount - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (power <= levelRange[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // ✅ 배열 범위 초과 방지
        if (start >= level.length) return level[level.length - 1];
        return level[start];
    }
}
