package com.test.manager.service.impl;

import com.test.manager.mapper.UserMapper;
import com.test.manager.model.User;
import com.test.manager.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ycw on 2016/3/10.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public String getUserNameByAccount(String account) {
        return userMapper.getUserNameByAccount(account);
    }
}
