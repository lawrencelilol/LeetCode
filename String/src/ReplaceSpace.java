public class ReplaceSpace {
    public static void main(String[] args) {
        ReplaceSpace rs = new ReplaceSpace();

        String s = "    ";

        s = rs.replaceSpace(s);
        System.out.println(s);
    }
    public String replaceSpace(String s) {

        if(s == null) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
