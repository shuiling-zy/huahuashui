package com.scuec.entity;

public class VerificationCode {

    private  int  id;

    private String code;

    private String email;



    public VerificationCode() {
    }

    public VerificationCode(String code, String email) {
        this.code = code;
        this.email = email;
    }

    public VerificationCode(int id, String code, String email) {
        this.id = id;
        this.code = code;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "VerificationCode{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
