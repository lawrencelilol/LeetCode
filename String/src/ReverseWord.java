import java.util.Arrays;

public class ReverseWord {
    public static void main(String[] args) {
        ReverseWord rw = new ReverseWord();
        String s = "the sky is blue";
        String ans = rw.reverseWords(s);

        System.out.println(ans);
    }
    public String reverseWords(String s) {
        s = s.trim();
        String[] arrays = s.split(" ");

        int left = 0;
        int right = arrays.length - 1;
        StringBuilder sb = new StringBuilder();

        while(left < right) {
            if(arrays[left].equals("")) {
                left++;
            } else if(arrays[right].equals("")) {
                right--;
            } else {
                String tmp = arrays[right];
                arrays[right] = arrays[left];
                arrays[left] = tmp;
                right--;
                left++;
            }
        }

        for(String word: arrays){
            if(!word.equals("")){
                sb.append(word + " ");
            }
        }
        return sb.toString().trim();
    }
}
