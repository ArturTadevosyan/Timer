public class MyTimer {
    private int minute;
    private int second;

    public MyTimer(int minute, int second) {
        this.minute = minute;
        this.second = second;
    }

    public void start() {
        printTime();
        while (minute != 0 || second != 0) {
            if (second == 0) {
                second = 59;
                minute--;
            } else {
                second--;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            printTime();
        }
    }

    private void printTime() {
        String mm = minute < 10 ? "0" + minute : minute + "";
        String ss = second < 10 ? "0" + second : second + "";
        System.out.println(mm + " : " + ss);
    }
}
