package com.CXF.webservice.impl;

import com.CXF.service.GetStaffServer;
import com.CXF.webservice.UserForStaff;
import com.alibaba.druid.util.StringUtils;
import com.commen.cst.Const;
import com.commen.pojo.*;
import com.commen.utils.JaxbUtil;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "SingleSignOnService",
        targetNamespace ="http://impl.webservice.CXF.com",
        endpointInterface = "com.CXF.webservice.UserForStaff")
public class UserForStaffImpl implements UserForStaff {

    @Autowired
    private GetStaffServer getStaffServer;
    /**
     *     1、提供获取员工对应的用户信息的接口
     *xmlparam参数内容如下：
     *<?xml version="1.0" encoding="utf-8"?>
     *<root>
     *  <staffKey>员工标识</staffKey>
     *</root>
     *返回值说明：
     *<?xml version="1.0" encoding="utf-8"?>
     *<root>
     *<users>
     *  <user>
     *  <userName>用户名</userName>
     *      <staffName>姓名</staffName>
     *      <employeNo>工作牌号</employeNo>
     *  </user>
     *</users>
     * </root>
     */
    public String GetUserByStaff(String xmlparam){
        try {
            //1.1、解析xml数据
            StaffKey staffKey = JaxbUtil.converyToJavaBean(xmlparam, StaffKey.class);
            //1.2、获取员工标识--可以用员工’姓名/工作牌号’的方式，或者直接使用平台的员工号。
            String staff =  staffKey.getStaffKey();
            String userByStaff = getStaffServer.getUserByStaff(staff);
            return userByStaff;
        }catch (Exception e) {
            e.printStackTrace();
            return "error:不存在该人";
        }
    }

    //2、获取员工有权限登录的系统信息
    public String GetStaffSystem(String xmlparams){
        try {
            //2.1、解析xml数据
            StaffSystem staffSystem = JaxbUtil.converyToJavaBean(xmlparams, StaffSystem.class);
            //2.2、staffKey：为员工编号,根绝staffKey查询用户的信息，返回员工用户信息给调用者
                List<LoginSystem> list = new ArrayList<LoginSystem>();
                    list.add(new LoginSystem(Const.LOGINSYSTEMCODE,Const.LOGINSYSTEMNAME));
                staffSystem.setLoginSystems(list);
                staffSystem.setCustomSystemCode(Const.CUSTOMSYSTEMCODE);
            //序列化数据
            return JaxbUtil.convertToXml(staffSystem,"UTF-8");
        }catch (Exception e) {
            e.printStackTrace();
            return "error:不存在该人";
        }
    }

    //3、获取员工有权限登录的科室信息--科室代码统一未171
    public String GetStaffDept(String xmlparam){
        System.out.println(xmlparam);
        try {
            //2.1、解析xml数据
            StaffDept staffDept = JaxbUtil.converyToJavaBean(xmlparam, StaffDept.class);
            //2.2、staffKey：为员工编号,根绝staffKey查询用户的信息，返回员工用户信息给调用者
            return getStaffServer.getStaffDept(staffDept);
        }catch (Exception e) {
            e.printStackTrace();
            return "error:不存在该人";
        }
    }

}
