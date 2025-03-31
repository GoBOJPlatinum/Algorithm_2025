package Park.week6;

public class 14620 {
    static int n;
	static int[][] map;
	static boolean[][] visited;
	// 상 하 좌 우
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int minCost = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// depth,cost
		dfs(0,0);

		System.out.println(minCost);
	}

	static void dfs(int depth, int cost){
		if (depth == 3) {
			minCost = Math.min(minCost, cost);
			return;
		}
		for(int i = 1; i < n - 1;i++){
			for(int j = 1; j < n - 1; j++){
				if(canPlace(i,j)){
					int currentCost = placeFlower(i,j,true);
					//System.out.println(currentCost);
					dfs(depth + 1, cost + currentCost);
					placeFlower(i,j,false);
				}
			}
		}
	}

	static boolean canPlace(int y, int x){
		// 5칸 전부 확인해야 하니까 4방향 + 중심도 검사 필요
		if (visited[y][x]) return false; // 중심 좌표도 검사!

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (visited[ny][nx]) return false;
		}

		return true;
	}

	static int placeFlower(int y, int x , boolean plant){
		int cost = 0;
		if(plant){
			for(int i  =0; i < 4; i++){
				visited[y + dy[i]][x+dx[i]] = true;
				cost += map[y + dy[i]][x+dx[i]];
			}
			visited[y][x] = true;
			cost += map[y][x];
		} else{
			for(int i  =0; i < 4; i++){
				visited[y + dy[i]][x+dx[i]] = false;
			}
			visited[y][x] = false;
		}

		return cost;
	}
    
}
