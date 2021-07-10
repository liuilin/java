package com.imugen.controller;

import com.imugen.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.*;

/**
 * 常用的注解
 */
@RestController
@RequestMapping( "/anno" )
@SessionAttributes( value = {"msg"} )   // 把msg=美美存入到session域对中
public class AnnoController {
    @Autowired
    HttpServletRequest httpServletRequest;


    @GetMapping( "/test1" )
    public List<String> test1(@RequestParam("uname") String username,@RequestParam("tenantId") String tenantId,@RequestParam List<String> cIds) {
        System.out.println("username = " + username);
        System.out.println("tenantId = " + tenantId );
        return cIds;
//        System.out.println(httpServletRequest.getRequestURL());
//        System.out.println(httpServletRequest.getQueryString());
//        System.out.println("执行了...");11
//        System.out.println(username);
//        System.out.println("user = " + user );
//        return user;
    }

    public static void main(String[] args) {
        testNull(null);
//        System.out.println(Collections.emptyList());

    }
    public static void testNull(User user){
        //java8：Optional.ofNullable()
        //判断非空Objects.requireNonNull(after);   Objects.nonNull(Object obj);
        //返回集合时返回空集合不要返回null：if(CollectionUtils.isEmpty(userList)){
        //return Lists.newArrayList();//guava类库提供的方式}
        assert user != null;
        Objects.requireNonNull(user,"user is null");
        System.out.println("user = " + user );
        System.out.println(user.getUname());
    }

    //    @RequestMapping("/testRequestParam")
    @GetMapping( "/testRequestParam" )
    public User testRequestParam(@RequestParam( name = "name" ) String username,User user) {
        if (user == null) {
            user = new User();
        }
        System.out.println("user = " + user.getUname());
        System.out.println(httpServletRequest.getRequestURL());
        System.out.println(httpServletRequest.getQueryString());
        System.out.println("执行了1...");
        System.out.println(username);
        return user;
    }

    /**
     * 获取到请求体的内容
     *
     * @return
     */
    @RequestMapping( "/testRequestBody" )
    public String testRequestBody(@RequestParam( name = "name" ) String username,@RequestBody String body) {
        System.out.println("username = " + username );
        System.out.println("执行了...");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     *
     * @return
     */
    @RequestMapping( value = "/testPathVariable/{sid}" )
    public String testPathVariable(@PathVariable( name = "sid" ) String id) {
        System.out.println("执行了...");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     *
     * @param header
     * @return
     */
    @RequestMapping( value = "/testRequestHeader" )
    public String testRequestHeader(@RequestHeader( value = "Accept" ) String header, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("执行了...");
        System.out.println(header);
        // return "success";
        // response.sendRedirect(request.getContextPath()+"/anno/testCookieValue");
        return "redirect:/param.jsp";
    }


    /**
     * 获取Cookie的值
     *
     * @return
     */
    @RequestMapping( value = "/testCookieValue" )
    public String testCookieValue(@CookieValue( value = "JSESSIONID" ) String cookieValue) {
        System.out.println("执行了...");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     *
     * @return
     */
    @RequestMapping( value = "/testModelAttribute" )
    public String testModelAttribute(@ModelAttribute( "abc" ) User user) {
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void showUser(String uname, Map<String, User> map) {
        System.out.println("showUser执行了...");
        // 通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        map.put("abc", user);
    }

    /**
     * 该方法会先执行

     @ModelAttribute public User showUser(String uname){
     System.out.println("showUser执行了...");
     // 通过用户查询数据库（模拟）
     User user = new User();
     user.setUname(uname);
     user.setAge(20);
     user.setDate(new Date());
     return user;
     }
     */

    /**
     * SessionAttributes的注解
     *
     * @return
     */
    @RequestMapping( value = "/testSessionAttributes" )
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes...");
        // 底层会存储到request域对象中
        model.addAttribute("msg", "美美");
        return "success";
    }

    /**
     * 获取值
     *
     * @param modelMap
     * @return
     */
    @RequestMapping( value = "/getSessionAttributes" )
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     *
     * @param status
     * @return
     */
    @RequestMapping( value = "/delSessionAttributes" )
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("getSessionAttributes...");
        status.setComplete();
        return "success";
    }

}














