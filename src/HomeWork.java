public class HomeWork {

    public static void main(String[] args) {
        boolean res = luckyTicket(1331);
        System.out.println("lucky: " + res);
    }

    //// ------ lesson 9 ------- ////

// --- with for ---
    public static boolean luckyTicket(int num) {
        int odd = 0;
        int even = 0;
        boolean digitOdd;
        for (digitOdd=false; num != 0; num/=10) {
            if (digitOdd==false){
                odd += num % 10;
                digitOdd=true;
            } else {
                even += num % 10;
                digitOdd=false;
            }
        }
        return odd == even ? true : false;
    }

// --- with wile ---
//    public static boolean luckyTicket(int num) {
//        int odd = 0;
//        int even = 0;
//        boolean digitOdd=false;
//        while (num != 0) {
//            if (digitOdd==false){
//                odd += num % 10;
//                digitOdd=true;
//            } else {
//                even += num % 10;
//                digitOdd=false;
//            }
//            num /= 10;
//        }
//        return odd == even ? true : false;
//    }
}
