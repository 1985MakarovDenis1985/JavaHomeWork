package model;

public class Printer implements Runnable {
    Thread threadLink;
    final int TOTAL = 103;
    final int CHUNKS = 5;
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
        for (int i = 1; i < TOTAL + 1; i++) {
            System.out.println(num);
            if (i % CHUNKS == 0) {
                if (i == TOTAL) {
                    System.out.println(num + "finish");
                }
                threadLink.interrupt();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }
    }


    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            startPrint();
        }
    }
}
