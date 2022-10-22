package com.example.todoapp;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskStorage
{
    private static TaskStorage taskStorage;

    private final List<Task> tasks;

    public static TaskStorage getInstance()
    {
        if(taskStorage==null)
        {
            taskStorage=new TaskStorage();
        }
        return taskStorage;
    }
    private TaskStorage()
    {
        tasks=new ArrayList<Task>();
        for(int i=0;i<=150;i++)
        {
            Task task=new Task();
            task.setName("Pilne zadanie numer "+ i);
            task.setDone(i%3==0);
            tasks.add(task);
        }
    }

    public List<Task> GetTasks()
    {
        return tasks;
    }
    public Task GetTask(UUID id)
    {
        for(Task task : tasks){
            if(task.getId().equals(id))
            {
                return task;
            }
        }

        return null;
    }
}
