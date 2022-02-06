import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    public static void main(String[] args) {
        PhoneNumber pn = new PhoneNumber();
        System.out.println(pn.letterCombinations("23"));
    }
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return list;
        }

        String[] map = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        letterCombinationHelper(digits,map,0);
        return list;
    }

    StringBuilder tmp = new StringBuilder();

    void letterCombinationHelper(String digits, String[] map, int start) {
        if(start == digits.length()) {
            list.add(tmp.toString());
            return;
        }

        String str = map[digits.charAt(start) - '0'];
        for (int i = 0; i < str.length(); i++) {
            tmp.append(str.charAt(i));
            letterCombinationHelper(digits,map,start + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
