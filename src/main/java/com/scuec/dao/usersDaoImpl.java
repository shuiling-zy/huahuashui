package com.scuec.dao;

import com.scuec.entity.Users;

import java.util.List;

public class usersDaoImpl extends BaseDaoImpl implements BaseDao{

//    public users getById(int id) {
//        String sql = "select * from users where id=?";
//        List<users> list = super.query(sql, new Object[]{id}, users.class);
//        return  (list!=null&&list.size()>0) ? list.get(0) : null;
//    }

    @Override
    public Users getByEamil(String email) {
        String sql = "select * from users where email=?";
        List<Users> list = super.query(sql, new Object[]{email}, Users.class);
        return  (list!=null&&list.size()>0) ? list.get(0) : null;
    }

    public List<Users> getList() {
        String sql = "select * from users";
        List<Users> list = super.query(sql, null, Users.class);
        return list;
    }


    public void add(Users user) {
        //外键约束
        String sql = "insert into users(password,email) values(?,?)";
        Object[] paramsValue = {user.getPassword(),user.getEmail()};
        super.Update(sql, paramsValue);
    }


    public void update(Users user) {
        String sql = "update into users (password) values (?)";
        Object[] paramsValue = {user.getPassword()};
        super.Update(sql, paramsValue);
    }

    public void delete(int id) {
        String sql = "delete from users where id=?";
        Object[] paramsValue = {id};
        super.Update(sql, paramsValue);
    }
}
