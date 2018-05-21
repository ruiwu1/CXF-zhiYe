package com.CXF.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 提供单点登录接口，对接智业接口，统一XML参数格式
 */
@WebService
public interface UserForStaff {

    //1、提供获取员工对应的用户信息的接口
    public String GetUserByStaff(@WebParam(name = "xmlparam") String xmlparam);
    //2、获取员工有权限登录的系统信息
    public String GetStaffSystem(@WebParam(name = "xmlparams") String xmlparams);
    //3、获取员工有权限登录的科室信息
    public String GetStaffDept(@WebParam(name = "xmlparam") String xmlparam);
}
