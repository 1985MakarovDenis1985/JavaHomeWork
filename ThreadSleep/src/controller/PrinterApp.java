package controller;

import model.Printer;

public class PrinterApp {
    public static void main(String[] args) {
        Printer printer1 = new Printer(); Printer printer2 = new Printer(); Printer printer3 = new Printer();
        printer1.setNum(1); printer2.setNum(2); printer3.setNum(3);
        Thread thread1 = new Thread(printer1); Thread thread2 = new Thread(printer2); Thread thread3 = new Thread(printer3);
        printer1.setThreadLink(thread2); printer2.setThreadLink(thread3); printer3.setThreadLink(thread1);

        Thread[] threads = {thread1, thread2, thread3};
        for (int i=0; i<threads.length; i++){

        }

        for (int i=0; i<threads.length; i++){
            threads[i].start();
        }
        thread1.interrupt();

    }
}
