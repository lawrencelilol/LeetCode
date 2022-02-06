import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<>();
    Deque<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        partitionHelper(s,0);
        return res;
    }

    void partitionHelper(String s, int startIndex) {
        if(startIndex >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length() ; i++) {
            if(isPalindrome(s,startIndex,i)) {
                String str = s.substring(startIndex,i + 1);
                path.add(str);
            } else {
                continue;
            }
            partitionHelper(s, startIndex + 1);
            path.removeLast();
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++,j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
