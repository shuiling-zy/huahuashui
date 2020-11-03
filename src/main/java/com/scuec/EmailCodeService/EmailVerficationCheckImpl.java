package com.scuec.EmailCodeService;

import com.scuec.dao.VerficationCodeDaoImpl;
import com.scuec.dao.usersDaoImpl;
import com.scuec.entity.Users;
import com.scuec.entity.VerificationCode;

public class EmailVerficationCheckImpl {


    private String email;

    private String password;

    private String code;

    public EmailVerficationCheckImpl(String email,String password, String code) {
        this.email = email;
        this.password = password;
        this.code = code;
    }

    public EmailVerficationCheckImpl() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "EmailVerficationCheckImpl{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    usersDaoImpl udi = new usersDaoImpl();                             //用户处理
    VerficationCodeDaoImpl vcdi = new VerficationCodeDaoImpl();         //验证码处理


    Users user = new Users();                                    //存放用户信息
    VerificationCode vweb = new VerificationCode();              //来自web的验证码和邮箱
    VerificationCode vdb = new VerificationCode();               //来自数据库的验证码和邮箱


    public boolean check(){


        /**
         * 从前端获得邮箱，密码和提交的验证码
         */
            user.setEmail(email);
            user.setPassword(password);
            vweb.setEmail(email);
            vweb.setCode(code);


        /**
         * 从数据库中读取对应邮箱的验证码
         */
            vdb.setCode(vcdi.getByEamil(vweb.getEmail()).getCode());


        /**
         *处理验证
         *
         */
            if (vweb.getCode().equals(vdb.getCode())) {

                //System.out.println("验证成功");

                udi.add(user);

                return true;

            }else {

                //System.out.println("验证码不一致");
                return false;
            }
    }

    public boolean checkuser(){
        /**
         * 查询用户是否存在
         */
        if ( udi.getByEamil(email) != null){
            return true;
        }else {
            return false;
        }
    }





}
