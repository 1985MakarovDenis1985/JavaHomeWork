package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Cockroach implements Runnable {
    private String name;
    private int dist;
    private int chunks = 0;
    static String winner = null;

    public Cockroach(String name, int dist) {
        this.name = name;
        this.dist = dist;
    }

    public String getWinner() {
        return winner;
    }

    private int randomMs(int start, int end){
        return start + (int) (Math.random() * end);
    }

    @Override
    public void run() {
        int time;
        for (int i = 0; i < dist; i++) {
            time = randomMs(2, 4);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.chunks++;
            if (chunks == dist) {
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/races.txt", true))) {
                    writer.write(name + ",");
                } catch (IOException e) {
                    e.printStackTrace();
                }



                //---------------
                if (winner == null ) {
                    winner = name;
                }
                System.out.println("Finshed = " + name);
            }
        }
    }
}
