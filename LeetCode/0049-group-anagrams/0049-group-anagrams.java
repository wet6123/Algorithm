class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            String sorted = sort_str(str);
            
            if(!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            }

            List<String> list = map.get(sorted);
            list.add(str);
        }

        List<List<String>> ans = new ArrayList<List<String>>();
        for (List<String> val : map.values()) {
            ans.add(val);
        }

        return ans;
    }
    public String sort_str(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}