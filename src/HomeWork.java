public class HomeWork {

    public static void main(String[] args) {
        boolean res = LN3(2310);
        System.out.println("lucky: " + res);
    }

    //// ------ lesson 9 ------- ////

    // --- HW --- class --- обьяснить как работает (какая идея)

    public static boolean LN3(int number) {
        int sum = 0;
        while (number != 0) {
            sum = number % 10 - sum;
            number /= 10;
        }
        return sum == 0;
    }

    // ----- ------ ------

//    public static boolean LN2(int number) {
//        int sum1 = 0;
//        int sum2 = 0;
//        while (number != 0) {
//            sum1 += number % 10;
//            number /= 10;
//            sum2 += number % 10;
//            number /= 10;
//        }
//        return sum1 == sum2;
//    }

// ----- ------ ------

//    public static boolean LN1(int number) {
//        int sum1 = 0;
//        int sum2 = 0;
//        int pos =1;
//        while (number!=0){
//            if (pos%2 == 0){
//                sum1 += number%10;
//            }else {
//                sum2 += number%10;
//            }
//            pos++;
//            number/=10;
//        }
//        return sum1==sum2;
//    }

// --- with for ---
//    public static boolean luckyTicket(int num) {
//        int odd = 0;
//        int even = 0;
//        boolean digitOdd;
//        for (digitOdd=false; num != 0; num/=10) {
//            if (digitOdd==false){
//                odd += num % 10;
//                digitOdd=true;
//            } else {
//                even += num % 10;
//                digitOdd=false;
//            }
//        }
//        return odd == even ? true : false;
//    }

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
