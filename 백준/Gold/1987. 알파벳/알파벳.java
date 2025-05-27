import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C, max = 0;
    static char[][] board;
    static boolean[] visited = new boolean[26];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        bw.write(String.valueOf(max));
        bw.close();
    }

    static void dfs(int x, int y, int count) {
        max = Math.max(max, count);

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                int idx = board[nx][ny] - 'A';
                if (!visited[idx]) {
                    visited[idx] = true;
                    dfs(nx, ny, count + 1);
                    visited[idx] = false;
                }
            }
        }
    }
}
