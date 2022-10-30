package com.example.todo;

public class TaskDetailsinfo {
    String title;

    String startdate;

    String enddate;

    String list;

    String tag;

    String description;


    public TaskDetailsinfo(String title, String startdate, String enddate, String list, String tag, String description) {
        this.title = title;
        this.startdate = startdate;
        this.enddate = enddate;
        this.list = list;
        this.tag = tag;
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle() {
        this.title = this.title;
    }

    public String getStartdate() {
        return this.startdate;
    }

    public void setStartdate() {
        this.startdate = this.startdate;
    }

    public String getEnddate() {
        return this.enddate;
    }

    public void setEnddate() {
        this.enddate = this.enddate;
    }

    public String getList() {
        return this.list;
    }

    public void setList() {
        this.list = this.list;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag() {
        this.tag = this.tag;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription() {
        this.description = this.description;
    }
}
