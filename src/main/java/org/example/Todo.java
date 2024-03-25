package org.example;

import java.sql.Date;

public class Todo {
    private int task_id;
    private String title;
    private String description;
    private int priority;
    private Date task_date;
    private boolean done;
    private boolean deleted;

    public Todo(String title, String description, int priority, Date task_date) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.task_date = task_date;
    }

    public Todo(int task_id, String title, String description, int priority, Date task_date, boolean done, boolean deleted) {
        this.task_id = task_id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.task_date = task_date;
        this.done = done;
        this.deleted = deleted;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getTask_date() {
        return task_date;
    }

    public void setTask_date(Date task_date) {
        this.task_date = task_date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "task_id=" + task_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", task_date=" + task_date +
                ", done=" + done +
                ", deleted=" + deleted +
                '}';
    }
}
