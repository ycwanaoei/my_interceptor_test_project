package com.test.manager.service;

import com.test.manager.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ycw on 2016/3/10.
 */
public interface IUserService {

    List<User> findAll();

    String getUserNameByAccount(String account);
}
