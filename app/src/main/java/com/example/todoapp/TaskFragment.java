package com.example.todoapp;


import static com.example.todoapp.TaskListFragment.KEY_EXTRA_TASK_ID;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.util.UUID;

public class TaskFragment extends Fragment
{
    private EditText nameField;
    private Button dateButton;
    private CheckBox doneCheckBox;
    private Button getBackButton;
    private Task task;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID taskID=(UUID) getArguments().getSerializable("taskID");

        task=TaskStorage.getInstance().GetTask(taskID);
    }
    public static TaskFragment newInstance(UUID taskID)
    {
        Bundle bundle=new Bundle();
        bundle.putSerializable("taskID", taskID);
        TaskFragment taskFragment=new TaskFragment();
        taskFragment.setArguments(bundle);

        return taskFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_task, container, false);
        nameField=view.findViewById(R.id.task_name);
        nameField.setText(task.getName());
        dateButton=view.findViewById(R.id.task_date);
        doneCheckBox=view.findViewById(R.id.task_done);
        getBackButton=view.findViewById(R.id.go_back_button);

        getBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TaskListActivity.class);
                startActivity(intent);
            }
        });

        nameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                task.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        dateButton.setText(task.getDate().toString());
        dateButton.setEnabled(false);

        doneCheckBox.setChecked(task.getDone());
        doneCheckBox.setOnCheckedChangeListener(((buttonView, isChecked) -> task.setDone(isChecked)));

        return view;
    }
}
