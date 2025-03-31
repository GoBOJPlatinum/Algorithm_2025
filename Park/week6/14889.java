package Park.week6;

public class 14889 {
    static int N;
	static int[][] stat;
	static boolean[] selected;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stat = new int[N][N];
		selected = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);
		System.out.println(min);
	}

	static void comb(int idx, int depth) {
		if (depth == N / 2) {
			calculate();
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				comb(i + 1, depth + 1);
				selected[i] = false;
			}
		}
	}

	static void calculate() {
		int start = 0, link = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (selected[i] && selected[j]) {
					start += stat[i][j] + stat[j][i];
				} else if (!selected[i] && !selected[j]) {
					link += stat[i][j] + stat[j][i];
				}
			}
		}
		min = Math.min(min, Math.abs(start - link));
	}
}
