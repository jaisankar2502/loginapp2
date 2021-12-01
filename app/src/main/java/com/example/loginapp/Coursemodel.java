package com.example.loginapp;

public class Coursemodel{
    private String courseName;
    private String courseDuration;
    private String courseTracks;
    private String courseDescription;
    private int id;

    public Coursemodel(String courName, String courDuration, String courTracks, String courDescription) {
        this.courseName=courName;
        this.courseDuration=courDuration;
        this.courseTracks=courTracks;
        this.courseDescription=courDescription;

    }
    public  String getCourseName(){
        return courseName;
    }
    public String getCourseDuration(){
        return courseDuration;
    }
  public String getCourseTracks(){
        return courseTracks;
    }
    public String getCourseDescription(){
        return courseDescription;
    }
    public  int getId(){
        return id;
    }
    public  void setId(int id){
        this.id=id;
    }

}
