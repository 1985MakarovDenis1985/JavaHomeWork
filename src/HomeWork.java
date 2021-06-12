public class HomeWork {

    public static void main(String[] args) {
        boolean res = luckyTicket(1441);
        System.out.println("lucky: " + res);
    }

    //// ------ lesson 9 ------- ////

    public static boolean luckyTicket(int num) {
        int odd = 0;
        int even = 0;
        boolean digitOdd=false;
        while (num != 0) {
            if (digitOdd==false){
                odd += num % 10;
                digitOdd=true;
            } else {
                even += num % 10;
                digitOdd=false;
            }
            num /= 10;
        }
        System.out.println("left: " + odd);
        System.out.println("right: " + even);
        return odd == even ? true : false;
    }
}
