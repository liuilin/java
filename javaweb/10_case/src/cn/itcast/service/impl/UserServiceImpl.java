package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author Gakki
 * @date 2018/11/19 - 16:57
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        //调用dao完成查询
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        //调用dao添加用户
        dao.add(user);
    }

    @Override
    public void delUser(String id) {
        //调用dao删除用户
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUser(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
//        if (ids != null && ids.length > 0) {
        for (String id : ids) {
            dao.delete(Integer.parseInt(id));
        }
//        }
    }

    @Override
    public PageBean<User> findUserByPage(String ccurrentPage, String rrows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(ccurrentPage);
        int rows = Integer.parseInt(rrows);

        if (currentPage < 1) {
            currentPage = 1;
        }


        //1.创建pagebean对象
        PageBean<User> pb = new PageBean<User>();

        //2.设置页面和rows属性
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //3.dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.计算起始索引
        int start = (currentPage - 1) * rows;
        //5.dao查询list集合
        List<User> list = dao.findByPage(start, rows,condition);
        pb.setList(list);
        //6.计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        //7.返回pagebean对象
        return pb;
    }
}
