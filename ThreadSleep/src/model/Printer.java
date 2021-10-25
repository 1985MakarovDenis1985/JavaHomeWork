package model;

public class Printer implements Runnable {
    Thread threadLink;
    final int TOTAL = 13;
    final int CHUNKS = 7;
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

    @Override
    public void run() {
        try {

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            for (int i = 1; i < TOTAL + 1; i++) {
                System.out.print(num + " ");
                if (i % CHUNKS == 0) {
                    System.out.println();
                    threadLink.interrupt();
                    try {
                        if (i != TOTAL) {
                            Thread.sleep(10000);
                        }
                    } catch (InterruptedException ex) {

                    }
                }

                if (i > TOTAL - TOTAL % CHUNKS && i % TOTAL % CHUNKS == 0) {
                    System.out.println();
                    threadLink.interrupt();
                }
            }
        }
    }
}
