class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        List<String> temp = new ArrayList<>();
        String[] sorted = sorts(strs);

        for(int i=0; i<strs.length; i++){
            if(set.contains(i)) continue;
            temp.add(strs[i]);

            for(int j=i+1; j<strs.length; j++){
                if(!set.contains(j)){
                    if(sorted[i].equals(sorted[j])){
                        temp.add(strs[j]);
                        set.add(j);
                    }
                }
            }

            result.add(new ArrayList<>(temp));
            temp.clear();
        }

        return result;
    }

    boolean checkAnagram(String s1, String s2){
        int[] freq = new int[26];

        for(char x: s1.toCharArray()) freq[x-'a']++;
        for(char x: s2.toCharArray()) freq[x-'a']--;

        for(int x: freq) if(x!=0) return false;
        return true;
    }

    String[] sorts(String[] arr){
        String[] result = new String[arr.length];
        int k=0;

        for(String s: arr){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            result[k++] = new String(charArray);
        }

        return result;
    }
}
