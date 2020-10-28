package com.scuec.dao;


import com.scuec.entity.VerificationCode;

import java.util.List;

public class VerficationCodeDaoImpl extends BaseDaoImpl implements BaseDao{

    //VerificationCode
    @Override
    public VerificationCode getByEamil(String email) {
        String sql = "select * from VerificationCode where email=?";
        List<VerificationCode> list = super.query(sql, new Object[]{email}, VerificationCode.class);
        return  (list!=null&&list.size()>0) ? list.get(0) : null;
    }

    public List<VerificationCode> getList() {
        String sql = "select * from VerificationCode";
        List<VerificationCode> list = super.query(sql, null, VerificationCode.class);
        return list;
    }


    public void add(VerificationCode verificationCode) {
        //外键约束
        String sql = "insert into VerificationCode(id,code,email) values(?,?,?)";
        Object[] paramsValue = {verificationCode.getId(),verificationCode.getCode(),verificationCode.getEmail()};
        super.Update(sql, paramsValue);
    }


    public void update(VerificationCode verificationCode) {
        String sql = "update into VerificationCode(password) values (?)";
        Object[] paramsValue = {verificationCode.getCode()};
        super.Update(sql, paramsValue);
    }

    public void delete(int id) {
        String sql = "delete from VerificationCode where id=?";
        Object[] paramsValue = {id};
        super.Update(sql, paramsValue);
    }
}
