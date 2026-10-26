class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] suffix = new int[nums.length];
        int[] prefix = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int j=nums.length-(1+i);

            if(i==0){
                prefix[i] = nums[i];
                suffix[j] = nums[j];
            }
            else{
                prefix[i] = prefix[i-1]*nums[i];
                suffix[j] = suffix[j+1]*nums[j];
            }
        }

        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int idx1 = i-1;
            int idx2 = i+1;

            if(idx1<0) ans[i] = suffix[idx2];
            else if(idx2>=nums.length) ans[i] = prefix[idx1];
            else ans[i] = prefix[idx1]*suffix[idx2];
        }

        return ans;
    }
}  

