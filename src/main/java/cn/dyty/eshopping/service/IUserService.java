package cn.dyty.eshopping.service;


import cn.dyty.eshopping.bean.User;

public interface IUserService {

    public User selectUser(long userId);

    public User findByNP(String username,String password);

}
