import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	/*
	 * dfs들어가면서 개수 세기 센건 리스트에 저장 Baekjoon4963 업그레이드 문제 n : 지도의 크기
	 */
	static boolean[][] visited;
	static int[][] map;
	static ArrayList<Integer> countlist = new ArrayList<>();
	// 각 단지내 집이 수 저장할 배열 (마지막에 정렬 해 줘야함)
	static int n;
	static int count; // 총 단지 수
	static int sR, sC;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int ans = 1;
	static int minh;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			ans = 1;
			n = sc.nextInt();
			visited = new boolean[n + 2][n + 2];
			map = new int[n + 2][n + 2];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					int num = sc.nextInt();
					map[i][j] = num;
					max = Math.max(max, num);
					min = Math.min(min, num);
				}
			}

			//
			for (int i = min; i < max; i++) {
				count = 0;
				visited = new boolean[n + 2][n + 2];
				minh = i;
				for (int k = 1; k < map.length - 1; k++) {
					for (int j = 1; j < map[k].length - 1; j++) {
						if (map[k][j] > minh && !visited[k][j]) {
							sR = k;
							sC = j;
							count++;
							dfs(sR, sC);
							ans = Math.max(count, ans);
						}
					}
				}

			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	public static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int i = 0; i < dc.length; i++) {
			int newR = r + dr[i];
			int newC = c + dc[i];
			if (map[newR][newC] > minh && !visited[newR][newC]) {
				dfs(newR, newC);
			}
		}

		return;
	}

	public static boolean check() {
		for (int i = 1; i < map.length - 1; i++) {
			for (int j = 1; j < map[i].length - 1; j++) {
				if (map[i][j] > minh && !visited[i][j]) {
					sR = i;
					sC = j;
					return false;
					// 만약 방문한 적 없는 섬이 있다면 그 시작 점을 저장하고 거기서부터 dfs시작
				}
			}
		}
		return true; // 섬은 전부다 방문했다면 나가기
	}
}
