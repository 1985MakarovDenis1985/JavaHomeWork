package model;

public class Printer implements Runnable {
    Thread threadLink;
    final int count = 6;
    int counter = 0;
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
        for (int i = 0; i < count; i++) {
            System.out.println(num);
            if (i == 1) {
                threadLink.interrupt();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
        System.out.println(num + "finally");
        counter++;
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
