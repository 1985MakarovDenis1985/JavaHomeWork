package Race;

public class RaceApp {
    private static final int SIZE = 5;
    private static final int DIST = 3;


    public static void main(String[] args) throws InterruptedException {
        String winner = "";

        Cockroach[] cockroaches = new Cockroach[SIZE];
        for (int i = 0; i < SIZE; i++) {
            cockroaches[i] = new Cockroach("Tarakan № " + i, DIST);
        }

        Thread[] threads = new Thread[SIZE];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(cockroaches[i]);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("---- Winner ----");
        System.out.println(cockroaches[0].getWinner());
        System.out.println("---- Silver ----");
        System.out.println(cockroaches[0].getSilver());
        System.out.println("---- Gold ----");
        System.out.println(cockroaches[0].getBronze());

    }
}


