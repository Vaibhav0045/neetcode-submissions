class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int x: nums){
            if(freq.containsKey(x)) return true;
            else freq.put(x,1);
        }
        return false;
    }
}