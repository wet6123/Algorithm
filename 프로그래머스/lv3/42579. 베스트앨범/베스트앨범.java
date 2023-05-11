import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static class Music {
        String genre;
        int play;
        int idx;
        
        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> gen = new HashMap<String, Integer>();
        int len = genres.length;
        for(int i = 0; i < len; i++) {
            if (gen.get(genres[i]) == null) {
                gen.put(genres[i], plays[i]);
            } else {
                gen.put(genres[i], gen.get(genres[i]) + plays[i]);
            }
        }
        
        ArrayList<String> genres_ordered = new ArrayList<>();
        while(gen.size() != 0) {
            int max = -1;
            String max_key = "";
            for(String key : gen.keySet()) {
                int tmp_cnt = gen.get(key);
                if(tmp_cnt > max) {
                    max = tmp_cnt;
                    max_key = key;
                }
            }
            genres_ordered.add(max_key);
            gen.remove(max_key);
        }
        
        ArrayList<Music> res = new ArrayList<>();
        for(String gern : genres_ordered) {
            ArrayList<Music> list = new ArrayList<>();
            for(int i = 0; i < genres.length; i++) {
                if(genres[i].equals(gern)){
                    list.add(new Music(gern, plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play);
            res.add(list.get(0));
            if(list.size() != 1) {
                res.add(list.get(1));
            }
        }
        
        int[] answer = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i).idx;
        }
        return answer;
    }
}