package thread;

public abstract class TimerTask implements Runnable {

    boolean cancelled = false;
    long nextTime = -1;
    long period;
    boolean fixedRate;

    protected TimerTask() {}

    public boolean cancel() {
        if (cancelled) return false;
        cancelled = true;
        if (nextTime == -1) return false;
        return true;
    }

    public long scheduledExecutionTime() { return nextTime; }

    public abstract void run();

    void schedule(long nextTime, long period, boolean fixedRate) {
        this.nextTime = nextTime;
        this.period = period;
        this.fixedRate = fixedRate;
    }

    boolean reschedule() {
        if (period == 0 || cancelled) return false;
        if (fixedRate) nextTime += period;
        else nextTime = System.currentTimeMillis() + period;
        return true;
    }
}
