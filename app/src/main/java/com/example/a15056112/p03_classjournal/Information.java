package com.example.a15056112.p03_classjournal;

import java.io.Serializable;

/**
 * Created by 15004543 on 4/5/2017.
 */

public class Information implements Serializable{
    private String week;
    private String grade;

    public Information(String week, String grade) {
        this.week = week;
        this.grade = grade;
    }

    public String getWeek() {

        return week;
    }

    public String getGrade() {

        return grade;
    }
}
