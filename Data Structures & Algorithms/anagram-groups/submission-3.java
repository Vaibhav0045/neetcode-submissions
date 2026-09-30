class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String word: strs){

            String sort_word = sequence(word);

            if(!map.containsKey(sort_word)){
                map.put(sort_word, new ArrayList<>());
            }

            map.get(sort_word).add(word);
        }

        return new ArrayList<>(map.values());
    }

    String sequence(String s){
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];

        for(char c: s.toCharArray()) freq[c-'a']++;
        for(int x: freq) sb.append(x-'0');

        return sb.toString();
    }
}
