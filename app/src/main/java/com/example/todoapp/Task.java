package com.example.todoapp;

import java.util.Date;
import java.util.UUID;

public class Task
{
    private UUID id;
    private String name;
    private Date date;
    private boolean done;

    public Task()
    {
        id=UUID.randomUUID();
        date=new Date();
        done=false;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setDone(boolean done)
    {
        this.done=done;
    }
    public Date getDate()
    {
        return date;
    }
    public boolean getDone()
    {
        return done;
    }
    public String getName()
    {
        return name;
    }
    public UUID getId()
    {
        return id;
    }
}
