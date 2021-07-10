package com.imugen.mybatis.io;

import java.io.InputStream;

/**
 * @author Daniel Liu 2020/2/12 7:14
 */
public class Resources {
    public static InputStream getResourceAsStream(String xmlPath) {
        return Resources.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
    }
}