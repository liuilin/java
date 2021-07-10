package com.imugen.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

/**
 * @author Daniel Liu 2020/3/13 10:39
 */
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String date) {
        Optional.ofNullable(date).orElseThrow(() -> new RuntimeException("不存在或是已被删除"));
        System.out.println(StringUtils.isEmpty(date));
//        localdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        try {
//            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
            return DateUtils.parseDate(date,
                    "yyyy-MM-dd",
                    "yyyy-MM-dd HH:mm",
                    "yyyy-MM-dd HH:mm:ss",
                    "yyyy-MM-dd HH:mm:ss.S",
                    "yyyy.MM.dd",
                    "yyyy.MM.dd HH:mm",
                    "yyyy.MM.dd HH:mm:ss",
                    "yyyy.MM.dd HH:mm:ss.S",
                    "yyyy/MM/dd",
                    "yyyy/MM/dd HH:mm",
                    "yyyy/MM/dd HH:mm:ss",
                    "yyyy/MM/dd HH:mm:ss.S");
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("解析异常");
        }
//        return DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(date);
    }
}