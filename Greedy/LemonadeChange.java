public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        LemonadeChange lc = new LemonadeChange();
        System.out.println(lc.lemonadeChange(bills));
    }
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) {
                five++;
            } else if(bills[i] == 10) {
                ten++;
                five--;
            } else if(bills[i] == 20) {
                if(ten > 0) {
                    ten --;
                    five--;
                } else {
                    five = five -3;
                }
            }
            if(five < 0 || ten < 0) {
                return false;
            }
        }
        return true;
    }
}
