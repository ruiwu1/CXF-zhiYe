package com.CXF.model;

/**
 * @author ruiwu
 * @version V1.0
 * @Description:
 */
public class postgreUser {

    private String loginID;
    private String passWD;

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getPassWD() {
        return passWD;
    }

    public void setPassWD(String passWD) {
        this.passWD = passWD;
    }

    public postgreUser() {
        super();
    }

    public postgreUser(String loginID, String passWD) {
        this.loginID = loginID;
        this.passWD = passWD;
    }

    @Override
    public String toString() {
        return "postgreUser{" +
                "loginID='" + loginID + '\'' +
                ", passWD='" + passWD + '\'' +
                '}';
    }
}
