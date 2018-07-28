package com.example;

public class UserServiceImpl implements UserService {
    @Override
    public String add() {
        System.out.println("增加用户");
        return "zhang san";
    }

    @Override
    public void update(int a) {
        System.out.println("修改用户");
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
        throw new RuntimeException("删除用户出错");
    }

    @Override
    public void search() {
        System.out.println("查询用户");
    }
}
