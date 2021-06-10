public class HomeWork {

    public static void main(String[] args) {
        starsFun(14, 5);
    }

    //// ------ lesson 8 ------- ////
    public static void starsFun(int n, int stars) {
        int reminder = n%stars;
        n = n + (stars-n%stars);

        while (n > stars-reminder) {
            if (n%stars == 1) {
                System.out.println("*");
                n--;
            } else {
                if (n != stars-reminder+1){
                    System.out.print("*");
                    n--;
                }else {
                    System.out.println("*");
                    n--;
                }
            }
        }
    }
}
