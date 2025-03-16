import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0; // target이 words 리스트에 없으면 변환 불가
        }

        return bfs(begin, target, words);
    }

    private int bfs(String begin, String target, String[] words) {
        Queue<WordNode> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.add(new WordNode(begin, 0)); // 시작 단어와 변환 횟수

        while (!queue.isEmpty()) {
            WordNode current = queue.poll();

            if (current.word.equals(target)) {
                return current.step; // 목표 단어에 도달하면 변환 횟수 반환
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new WordNode(words[i], current.step + 1));
                }
            }
        }

        return 0; // 변환할 수 없는 경우
    }

    private boolean canConvert(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1; // 한 글자만 다르면 true
    }

    static class WordNode {
        String word;
        int step;

        WordNode(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}
