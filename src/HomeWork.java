public class HomeWork {

    public static void main(String[] args) {
        starsFun(31, 4);
    }


    //// ------ lesson 8 ------- ////
    public static void starsFun(int n, int stars) {
        int x = n % stars + 1;
        System.out.println(x);

        while (n > 0) {
            if (n % stars != x && n % stars != x-5) {
                n--;
                if (n!=0){
                    System.out.print("*");
                } else {
                    System.out.println("*");
                }
            } else {
                System.out.println("*");
                n--;
            }
        }
    }

//    public static void stars(int n, int stars) {
//        boolean check = n%stars != 0;
//        int finger = 1;
//        while (n > 0) {
//            if (finger < stars ){
//                System.out.print("*");
//                finger++;
//            }else{
//                System.out.println("*");
//                finger = 1 ;
//            }
//            n--;
//        }
//        if (check){
//            System.out.println();
//        }
//    }


}
