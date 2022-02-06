public class ReverseString {



    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);

    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            left++;
            right --;
        }
    }
}
