package controller;

import model.Printer;

public class PrinterApp {
    public static void main(String[] args) {
        final int THREADS = 5;
        Printer[] printers = new Printer[THREADS];
        Thread[] threads = new Thread[THREADS];

        for (int i=0; i<threads.length; i++){
            printers[i] = new Printer();
            printers[i].setNum(i+1);
            threads[i] = new Thread(printers[i]);
        }

        for (int i=0; i < printers.length; i++){
            if (i < printers.length-1){
                printers[i].setThreadLink(threads[i+1]);
            }else {
                printers[i].setThreadLink(threads[0]);
            }
        }

        for (int i=0; i<THREADS; i++){
            threads[i].start();
        }
        threads[0].interrupt();
    }
}
