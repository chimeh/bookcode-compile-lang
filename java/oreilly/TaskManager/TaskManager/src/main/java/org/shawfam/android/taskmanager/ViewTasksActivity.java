package org.shawfam.android.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.shawfam.android.taskmanager.tasks.Task;

import java.util.ArrayList;

public class ViewTasksActivity extends TaskManagerActivity {

    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showTasks();
    }

    private void showTasks() {
        ArrayList<Task> tasks = getTaskManagerApplication().getCurrentTasks();
    }

    private void setUpViews() {
        addButton = (Button)findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewTasksActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });
    }

}
