package com.imugen.demo02.Lambda;

/**
 * @author Daniel
 * @date 2020/09/09
 **/
public class StudentScore {

    private String StuName;
    private String Subject;
    private Integer Score;

    @Override
    public String toString() {
        return "StudentScore{" +
                "StuName='" + StuName + '\'' +
                ", Subject='" + Subject + '\'' +
                ", Score=" + Score +
                '}';
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

//    public boolean hasOverEightyPoints() {
//        return this.Score>80;
//    }
}
