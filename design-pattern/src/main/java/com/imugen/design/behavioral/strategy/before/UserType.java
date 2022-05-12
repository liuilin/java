package com.imugen.design.behavioral.strategy.before;

/**
 * @author Daniel Liu 2020/2/25 9:45
 */
public enum UserType {
    /**
     * 白银会员
     */
    ORDINARY(0, "普通会员"), SILVER_VIP(1, "白银会员"), GOLD_VIP(2, "黄金会员"), PLATINUM_VIP(3, "白金会员");

    int type;
    String grade;

    UserType(int type, String grade) {
        this.type = type;
        this.grade = grade;
    }

    public int getType() {
        return type;
    }

    public String getGrade() {
        return grade;
    }
}
