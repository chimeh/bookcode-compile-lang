package thread;

import java.io.*;
import java.awt.*;
import javax.swing.*;

public class ThreadLister {

    private static void printThreadInfo(PrintWriter out, Thread t, String indent) {
        if (t == null) return;
        out.println(indent + "Thread: " + t.getName() +
            " Priority: " + t.getPriority() +
            (t.isDaemon() ? " Daemon" : "") +
            (t.isAlive() ? "" : " Not Alive")
        );
    }

    private static void printGroupInfo(PrintWriter out, ThreadGroup g, String indent) {
        if (g == null) return;
        int num_threads = g.activeCount();
        int num_groups = g.activeGroupCount();
        Thread[] threads = new Thread[num_threads];
        ThreadGroup[] groups = new ThreadGroup[num_groups];

        g.enumerate(threads, false);
        g.enumerate(groups, false);

        out.println(indent + "Thread Group" + g.getName() +
            " Max Priority: " + g.getMaxPriority() +
             (g.isDaemon() ? " Daemon" : "")
        );

        for (int i = 0; i < num_threads; i ++) {
            printThreadInfo(out, threads[i], indent + "    ");
        }
        for (int i = 0; i < num_groups; i ++) {
            printGroupInfo(out, groups[i], indent + "    ");
        }
    }

    public static void listAllThreads(PrintWriter out) {
        ThreadGroup current_thread_group;
        ThreadGroup root_thread_group;
        ThreadGroup parent;

        current_thread_group = Thread.currentThread().getThreadGroup();

        root_thread_group = current_thread_group;
        parent = root_thread_group.getParent();

        while(parent != null) {
            root_thread_group = parent;
            parent = parent.getParent();
        }

        printGroupInfo(out, root_thread_group, "");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ThreadLister Demo");
        JTextArea textarea = new JTextArea();

        frame.getContentPane().add(new JScrollPane(textarea), BorderLayout.CENTER);
        frame.setSize(500, 400);
        frame.setVisible(true);

        StringWriter sout = new StringWriter();
        PrintWriter out = new PrintWriter(sout);

        ThreadLister.listAllThreads(out);
        out.close();

        String threadListing = sout.toString();

        textarea.setText(threadListing);
    }

}
