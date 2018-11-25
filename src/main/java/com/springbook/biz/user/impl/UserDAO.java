package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private  final String USER_GET="select * from users where id=? and password=?";

    public UserVO getUser(UserVO vo){
        Object[] args = {vo.getId(), vo.getPassword()};
        return jdbcTemplate.queryForObject(USER_GET,
                args, new UserRowMapper());
    }

    class UserRowMapper implements RowMapper<UserVO> {
        public UserVO mapRow(ResultSet resultSet, int i) throws SQLException {

            UserVO user = new UserVO();
            user.setId(resultSet.getString("ID"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setName(resultSet.getString("NAME"));
            user.setRole(resultSet.getString("ROLE"));

            return user;

        }
    }
}
