public class AddDigits {
    public static void main(String[] args) {
        int num = 38;
        AddDigits ad = new AddDigits();
        System.out.println(ad.addDigits(num));
    }
    public int addDigits(int num) {
        if(num < 10) {
            return num;
        }
        String str = String.valueOf(num);

        int sum = 0;

        while(str.length() > 1) {
            sum = 0;
            for(char c: str.toCharArray()) {
                sum += Character.getNumericValue(c);
            }
            str = String.valueOf(sum);
        }

        return sum;
    }
}
