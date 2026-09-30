class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String word: strs){
            char[] c = word.toCharArray();

            Arrays.sort(c);

            String sort_word = String.valueOf(c);

            if(!map.containsKey(sort_word)){
                map.put(sort_word, new ArrayList<>());
            }

            map.get(sort_word).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
