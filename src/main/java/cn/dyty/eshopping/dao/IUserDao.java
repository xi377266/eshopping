package cn.dyty.eshopping.dao;


import cn.dyty.eshopping.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Component
@Repository
public interface IUserDao {

    User selectUser(long id);

    User findByNP(Map<String,String> paramMap);

}