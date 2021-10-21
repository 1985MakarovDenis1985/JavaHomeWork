package Race;

public class Cockroach implements Runnable {
    private String name;
    private int dist;
    private int chunks = 0;
    static String winner = null;
    static String silver = null;
    static String bronze = null;


    public Cockroach(String name, int dist) {
        this.name = name;
        this.dist = dist;
    }

//    public int getChunks() {
//        return chunks;
//    }
//
//    public String getName() {
//        return name;
//    }

    public String getWinner() {
        return winner;
    }

    public String getSilver() {
        return silver;
    }

    public String getBronze() {
        return bronze;
    }

    @Override
    public void run() {
        int a = 2;
        int b = 4;
        int time = 0;

//        System.out.println(name + " starting...");
        for (int i = 0; i < dist; i++) {
            time = a + (int) (Math.random() * b);

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.chunks++;
            if (chunks == dist) {
                if (winner == null && silver == null && bronze == null) {
                    winner = name;
                } else if (winner != null && silver == null && bronze == null) {
                    silver = this.name;
                } else if (winner != null && silver != null && bronze == null) {
                    bronze = name;
                }
                System.out.println("Finshed = " + name);
            }
        }
    }
}
