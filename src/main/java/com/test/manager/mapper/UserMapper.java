package com.test.manager.mapper;

import com.test.manager.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */
@Repository
public interface UserMapper {

    List<User> findAll();

    String getUserNameByAccount(@Param("account")String account);
}
