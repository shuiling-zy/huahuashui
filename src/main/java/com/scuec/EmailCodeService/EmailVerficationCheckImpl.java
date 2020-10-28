package com.scuec.EmailCodeService;

import com.scuec.dao.VerficationCodeDaoImpl;
import com.scuec.dao.usersDaoImpl;
import com.scuec.entity.Users;
import com.scuec.entity.VerificationCode;

public class EmailVerficationCheckImpl {

    usersDaoImpl udi = new usersDaoImpl();                             //用户处理
    VerficationCodeDaoImpl vcdi = new VerficationCodeDaoImpl();         //验证码处理


    Users user = new Users();                                    //存放用户信息
    VerificationCode vweb = new VerificationCode();              //来自web的验证码和邮箱
    VerificationCode vdb = new VerificationCode();               //来自数据库的验证码和邮箱


    /**
     * 从前端获得邮箱，密码和提交的验证码
     */

    public void web(){


    }



    /**
     * 从数据库中读取对应邮箱的验证码
     */

    public void db(Users user,usersDaoImpl udi,VerificationCode vdb){

        vdb.setEmail(user.getEmail());

        vdb.setCode(String.valueOf(udi.getByEamil(user.getEmail())));

    }

    /**
     *处理验证
     *
     */

    public boolean check(){
            if (vweb.getCode().equals(vdb.getCode())) {

                System.out.println("验证成功");

                udi.add(user);

                return true;

            }else {

                System.out.println("验证码不一致");
                return false;
            }
    }





}
