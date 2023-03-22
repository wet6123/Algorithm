import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			map.put(br.readLine(), 1);
		}
		for(int i = 0; i < m; i++) {
			String name = br.readLine();
			if(map.getOrDefault(name, 0) == 1) {
				list.add(name);
			}
		}
		Collections.sort(list);
		bw.write(list.size() + "\n");
		for(String s : list) {
			bw.write(s + "\n");
		}
		bw.close();
	}
}
