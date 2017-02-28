package org.shawfam.android.taskmanager.tasks;

/**
 * Created by Chris Shaw on 6/13/13.
 */
public class Task {
    private String name;

    public Task(String taskName) {
        name = taskName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

}
