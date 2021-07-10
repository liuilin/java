package cn.itcast.web.test;

import cn.itcast.web.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Gakki
 * @date 2018/11/28 - 11:46
 */
public class JacksonTest {

    @Test
    public void testJackson() throws IOException {
        Person p = new Person();
        p.setName("Gakki");
        p.setAge(26);
        p.setGender("female");


        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(new File("d://a.txt"),p);
//        mapper.writeValue(new FileWriter("d://b.txt"),p);
//        mapper.writeValue(new FileOutputStream("d://c.txt"),p);
        mapper.writeValueAsString(p);
    }
}
