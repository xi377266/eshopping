package cn.dyty.eshopping.service.impl;

import cn.dyty.eshopping.bean.User;
import cn.dyty.eshopping.dao.IUserDao;
import cn.dyty.eshopping.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    @Override
    public User findByNP(String username, String password) {
        Map<String,String> paramMap=new HashMap<String,String>();
        User user=userDao.findByNP(paramMap);
        return user;
    }

}
