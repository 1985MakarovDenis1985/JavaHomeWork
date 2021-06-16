public class HomeWork {

    public static void main(String[] args) {
        figure1(8);
        System.out.println();
        figure2(8);
        System.out.println();
        figure3(8);
        System.out.println();
        figure4(8);
    }


    public static void figure4(int n) {
        int a = n;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= i && j < a || i == 1 || i == n || j == 1 || j == n || i == j || j == a) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            a--;
            System.out.println();
        }
    }

    public static void figure3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= i || i == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void figure2(int n) {
        int a = n;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n || i == j || j == a) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            a--;
            System.out.println();
        }
    }

    public static void figure1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n || i == j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
