package thread;

import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

public class Timer {

    SortedSet tasks = new TreeSet(new Comparator() {
      public int compare(Object a, Object b) {
          return (int)(((TimerTask) a).nextTime-((TimerTask) b).nextTime);
      }

      public boolean equals(Object o) { return this == o; }
    });

    TimerThread timer;

    public Timer() { this(false); }

    public Timer(boolean isDaemon) {
        timer = new TimerThread(isDaemon);
        timer.start();
    }

    public void cancel() {
        synchronized (tasks) {
            timer.pleaseStop();
            tasks.clear();
            tasks.notify();
        }
    }

    public void schedule(TimerTask task, long delay) {
        task.schedule(System.currentTimeMillis() + delay, 0, false);
        schedule(task);
    }

    public void schedule(TimerTask task, Date time) {
        task.schedule(time.getTime(), 0, false);
        schedule(task);
    }

    public void schedule(TimerTask task, Date firstTime, long period) {
        task.schedule(firstTime.getTime(), period, false);
        schedule(task);
    }

    public void schedule(TimerTask task, long delay, long period) {
        task.schedule(System.currentTimeMillis() + delay, period, false);
        schedule(task);
    }

    public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
        task.schedule(System.currentTimeMillis() + delay, period, true);
        schedule(task);
    }

    public void scheduleAtFixedRate(TimerTask task, Date firstTime, long period) {
        task.schedule(firstTime.getTime(), period, true);
        schedule(task);
    }

    void schedule(TimerTask task) {
        synchronized (tasks) {
            tasks.add(task);
            tasks.notify();
        }
    }

    class TimerThread extends Thread {

        volatile boolean stopped = false;

        TimerThread(boolean isDaemon) { setDaemon(isDaemon); }

        void pleaseStop() { stopped = true; }

        public void run() {
            TimerTask readyToRun = null;
            while(!stopped) {
                if (readyToRun != null) {
                    if (readyToRun.cancelled) {
                        readyToRun = null;
                        continue;
                    }

                    readyToRun.run();

                    if (readyToRun.reschedule())
                        schedule(readyToRun);

                    readyToRun = null;

                    continue;
                }

                synchronized (tasks) {
                    long timeout;
                    if (tasks.isEmpty()) {
                        timeout = 0;
                    }
                    else {
                        TimerTask t = (TimerTask) tasks.first();
                        timeout = t.nextTime = System.currentTimeMillis();

                        if (timeout <= 0) {
                            readyToRun = t;
                            tasks.remove(t);
                            continue;
                        }
                    }

                    try { tasks.wait(timeout); }
                    catch (InterruptedException e) {}
                }
            }
        }
    }

    public static class Test {

        public static void main(String[] args) {
            final TimerTask t1 = new TimerTask() {
                public void run() {System.out.println("boom"); }
            };

            final TimerTask t2 = new TimerTask() {
                public void run() {System.out.println("\tBOOM"); }
            };

            final TimerTask t3 = new TimerTask() {
                public void run() { t1.cancel(); t2.cancel(); }
            };

            final Timer timer = new Timer();
            timer.schedule(t1, 0, 500);
            timer.schedule(t2, 2000, 2000);
            timer.schedule(t3, 5000);

            timer.scheduleAtFixedRate(new TimerTask() {
                public int times = 5;
                public void run() {
                    System.out.println(times--);
                    if (times == 0) timer.cancel();
                }
            }, 5000, 500);

        }

    }

}
