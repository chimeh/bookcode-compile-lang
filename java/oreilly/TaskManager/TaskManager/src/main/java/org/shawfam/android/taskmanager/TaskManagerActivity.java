package org.shawfam.android.taskmanager;

import android.app.Activity;

/**
 * Created by Chris Shaw on 6/13/13.
 */
public class TaskManagerActivity extends Activity {

    protected TaskManagerApplication getTaskManagerApplication() {
        TaskManagerApplication tma = (TaskManagerApplication)getApplication();
        return tma;
    }
}