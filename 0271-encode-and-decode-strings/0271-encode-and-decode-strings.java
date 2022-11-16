public class Codec {
    String spliter = "/";
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            int len = s.length();
            sb.append(String.valueOf(len));
            sb.append(spliter);
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int N = s.length();
        List<String> res =new ArrayList<>();
        int i=0;
        while(i < N){
            int splitIdx = s.indexOf(spliter, i);
            int strLen = Integer.valueOf(s.substring(i, splitIdx));
            i = splitIdx + strLen + 1;
            String currStr = s.substring(splitIdx+1, i);
            res.add(currStr);
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));