package com.imugen.ui;

import com.imugen.dao.IAccountDao;
import com.imugen.service.IAccountService;
import com.imugen.service.IMessageService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.springframework.beans.factory.xml.BeanDefinitionParserDelegate.MULTI_VALUE_ATTRIBUTE_DELIMITERS;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     * <p>
     * ApplicationContext的三个常用实现类：
     * ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
     * FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
     * <p>
     * AnnotationConfigApplicationContext：它是用于读取注解创建容器的，是明天的内容。
     * <p>
     * 核心容器的两个接口引发出的问题：
     * ApplicationContext:     单例对象适用              采用此接口
     * 它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
     * <p>
     * BeanFactory:            多例对象使用
     * 它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("appcontext.xml", "bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\zhy\\Desktop\\bean.xml");
        //2.根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao dao = ac.getBean("accountDao", IAccountDao.class);
//        System.out.println(ac.getBean(IMessageService.class).getMessage());

        System.out.println(as);
        System.out.println(dao);
//        as.saveAccount();


        //--------BeanFactory----------
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        IAccountService as  = (IAccountService)factory.getBean("accountService");
//        System.out.println(as);
    }

    @Test
    public void t1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("appcontext.xml", "bean.xml");
        IMessageService ims = ac.getBean(IMessageService.class);
        IAccountService bean = ac.getBean(IAccountService.class);
        System.out.println(ims.getMessage());

        List<String> alias = new ArrayList<>();
        String[] nameArr = StringUtils.tokenizeToStringArray("hh;xixi", MULTI_VALUE_ATTRIBUTE_DELIMITERS);
//        List<String> alias = new ArrayList<>(Arrays.asList(nameArr));
//        alias.addAll(Arrays.asList(nameArr));
//        alias.forEach(System.out::println);

        Stream.of(alias.addAll(Arrays.asList(nameArr))).forEach(System.out::println);
//        Arrays.asList(nameArr).forEach(System.out::println);
    }
}
