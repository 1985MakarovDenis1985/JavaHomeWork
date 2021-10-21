package model;

import interfaces.IRace;

public class Race implements IRace {

    public void startRace(String ... args) {
        if (args.length > 2 || args.length < 2){
            System.out.println("Wrong args");
            return;
        }
        int count = Integer.parseInt(args[0]);
        int dist = Integer.parseInt(args[1]);
        System.out.println("In competition " + count + " cockroaches and the distance: " + dist + " meters");
        System.out.println("...3 ...2 ...1 ...START");

        Cockroach[] cockroaches = new Cockroach[count];
        for (int i = 0; i < count; i++) {
            cockroaches[i] = new Cockroach("Tarakan № " + i, dist);
        }

        Thread[] threads = new Thread[count];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(cockroaches[i]);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---- Winner : " + cockroaches[0].getWinner());
        System.out.println("---- Silver : " + cockroaches[0].getSilver());
        System.out.println("---- Bronze : " + cockroaches[0].getBronze());
    }
}

