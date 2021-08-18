package com.imugen.demo02.Lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Daniel
 * @date 2020/09/09
 **/
public class Merge {

    private static List<StudentScore> buildATestList() {
        List<StudentScore> studentScoreList = new ArrayList<>();
        StudentScore studentScore1 = new StudentScore() {{
            setStuName("张三");
            setSubject("语文");
            setScore(70);
        }};
        StudentScore studentScore2 = new StudentScore() {{
            setStuName("张三");
            setSubject("数学");
            setScore(80);
        }};
        StudentScore studentScore3 = new StudentScore() {{
            setStuName("张三");
            setSubject("英语");
            setScore(65);
        }};
        StudentScore studentScore4 = new StudentScore() {{
            setStuName("李四");
            setSubject("语文");
            setScore(68);
        }};
        StudentScore studentScore5 = new StudentScore() {{
            setStuName("李四");
            setSubject("数学");
            setScore(70);
        }};
        StudentScore studentScore6 = new StudentScore() {{
            setStuName("李四");
            setSubject("英语");
            setScore(90);
        }};
        StudentScore studentScore7 = new StudentScore() {{
            setStuName("王五");
            setSubject("语文");
            setScore(80);
        }};
        StudentScore studentScore8 = new StudentScore() {{
            setStuName("王五");
            setSubject("数学");
            setScore(85);
        }};
        StudentScore studentScore9 = new StudentScore() {{
            setStuName("王五");
            setSubject("英语");
            setScore(70);
        }};

        studentScoreList.add(studentScore1);
        studentScoreList.add(studentScore2);
        studentScoreList.add(studentScore3);
        studentScoreList.add(studentScore4);
        studentScoreList.add(studentScore5);
        studentScoreList.add(studentScore6);
        studentScoreList.add(studentScore7);
        studentScoreList.add(studentScore8);
        studentScoreList.add(studentScore9);

        return studentScoreList;
    }

//    @Test
    void main() {
        List<StudentScore> studentScores = buildATestList();
        studentScores.forEach(System.out::println);
        Map<String, Integer> map = new HashMap<>();
        studentScores.forEach(v -> map.merge(v.getStuName(), v.getScore(), Integer::sum));
        map.entrySet().forEach(System.out::println);
        System.out.println("map = " + map);

        List<StudentScore> collect = studentScores.stream().filter(this::hasOverEightyPoints).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    private boolean hasOverEightyPoints(StudentScore studentScore) {
        return studentScore.getScore() > 80;
    }

}
