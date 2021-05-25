public class Timer {
    private long startTime;

    public Timer() {
        this.startTime = System.currentTimeMillis();
    }

    public long time(){
        return System.currentTimeMillis()-startTime;

    }


}