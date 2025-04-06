import java.util.*;

public class Main {
    static int L, C;
    static char[] letters;
    static char[] result;
    static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        letters = new char[C];
        result = new char[L];

        for (int i = 0; i < C; i++) {
            letters[i] = sc.next().charAt(0);
        }

        Arrays.sort(letters);
        dfs(0, 0, 0, 0);
    }

    // idx: letters 배열에서의 인덱스
    // depth: result 배열에서의 위치
    // vowelCount: 모음 개수
    // consonantCount: 자음 개수
    static void dfs(int idx, int depth, int vowelCount, int consonantCount) {
        if (depth == L) {
            if (vowelCount >= 1 && consonantCount >= 2) {
                System.out.println(new String(result));
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            char ch = letters[i];
            result[depth] = ch;

            if (vowels.contains(ch)) {
                dfs(i + 1, depth + 1, vowelCount + 1, consonantCount);
            } else {
                dfs(i + 1, depth + 1, vowelCount, consonantCount + 1);
            }
        }
    }
}