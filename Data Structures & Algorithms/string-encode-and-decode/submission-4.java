class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            String len = String.valueOf(s.length());
            sb.append(len);
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> lst = new ArrayList<>();
        int n = s.length();
        int i = 0;

        while(i<n){
            int len = 0;
            while(s.charAt(i)!='#'){
                len *= 10;
                len += (s.charAt(i)-'0');
                i++;
            }

            i++;
            int j=i;
            StringBuilder sb = new StringBuilder();

            while((i-j)<len){
                sb.append(s.charAt(i));
                i++;
            }

            lst.add(sb.toString());
        }

        return lst;
    }
}
