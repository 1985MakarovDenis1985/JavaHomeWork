package model;

public class Printer implements Runnable {
    Thread threadLink;
    final int count = 6;
    int counter = 2;
    int num = 0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Thread getThreadLink() {
        return threadLink;
    }

    public void setThreadLink(Thread threadLink) {
        this.threadLink = threadLink;
    }

    void startPrint() {
        for (int i = 1; i < 7; i++) {
            System.out.println(num);
            if (i%2 == 0) {
                threadLink.interrupt();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
            counter++;
        }
        System.out.println(num + "finally");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
                startPrint();
//            threadLink.interrupt();
        }
    }
}
