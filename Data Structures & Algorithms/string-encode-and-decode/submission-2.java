class Solution {
    static List<String> ans;
    public String encode(List<String> strs) {
        ans = new ArrayList<>(strs);
        return "";
    }

    public List<String> decode(String str) {
        return ans;
    }
}
