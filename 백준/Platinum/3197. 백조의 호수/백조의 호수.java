import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        boolean[][][] map = new boolean[R][C][2];
        int idx = 0;
        int[][] L = new int[2][2];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String new_line = st.nextToken();
            for(int j = 0; j < C; j++) {
                if(new_line.charAt(j) != 'X') {
                    map[i][j][0] = true;
                    if(new_line.charAt(j) == 'L') {
                        L[idx][0] = i;
                        L[idx][1] = j;
                        idx++;
                    }
                }
                else
                    map[i][j][0] = false;
            }
        }
        Queue<Node> q = new LinkedList<>();
        Queue<Node> melt = new LinkedList<>();
        q.add(new Node(L[0][0], L[0][1]));
        int cnt = 0;
        boolean flag = true;
                
        while(!map[L[1][0]][L[1][1]][1]) {
			//맵 순회 녹은 곳 방문
			while(!q.isEmpty()) {
			    Node node = q.poll();
			    if(map[node.x][node.y][1] || !map[node.x][node.y][0])
			    	continue;
			    map[node.x][node.y][1] = true;
			    for(int i = 0; i < 4; i++) {
			    	int x = node.x + dx[i];
			    	int y = node.y + dy[i];
			    	if(x >= 0 && x < R && y >= 0 && y < C) {
//			    		if(map[x][y][0] && !map[x][y][1] && !q.contains(new Node(x, y)))
			    		if(map[x][y][0] && !map[x][y][1])
			    			q.add(new Node(x, y));
			    	}
			    }
			}
			if(map[L[1][0]][L[1][1]][1])
				break;
			//맵 순회하면서 녹일거 찾기
			if(flag) {
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						Node node = new Node(i, j);
						if(map[i][j][0] == false) {
							for(int k = 0; k < 4; k++) {
				            	int x = i + dx[k];
				            	int y = j + dy[k];
				            	if(x >= 0 && x < R && y >= 0 && y < C) {
				            		if(map[x][y][0]) {
			            				melt.add(node);
				            			break;
				            		}
				            	}
				            }
						}
					}
				}
				flag = false;
			}
			
			int num = melt.size();
			while(num > 0) {
				Node node = melt.poll();
				int i = node.x;
				int j = node.y;
				if(map[i][j][0] == false) {
					map[i][j][0] = true;
					for(int k = 0; k < 4; k++) {
		            	int x = i + dx[k];
		            	int y = j + dy[k];
		            	if(x >= 0 && x < R && y >= 0 && y < C) {
//		            		if(map[x][y][0] == false && !melt.contains(new Node(x, y)))
		            		if(map[x][y][0] == false)
		            			melt.add(new Node(x, y));
//		            		else if(map[x][y][1] && !q.contains(new Node(x, y)))
		            		else if(map[x][y][1])
		            			q.add(new Node(i, j));
		            	}
		            }
				}
				num--;
			}
			
			cnt++;
			
//			for(int i = 0; i < R; i++) {
//	            for(int j = 0; j < C; j++) {
//	            	if(map[i][j][0])
//	            		System.out.print("O");
//	            	else
//	            		System.out.print("X");
//	            }
//	            System.out.print("\n");
//	        }
//			System.out.print("------------------\n");
        }
        
//        for(int i = 0; i < R; i++) {
//            for(int j = 0; j < C; j++) {
//            	if(map[i][j][0])
//            		bw.write("O");
//            	else
//            		bw.write("X");
//            }
//            bw.write("\n");
//        }
        bw.write(cnt + "");
        bw.close();
    }
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}