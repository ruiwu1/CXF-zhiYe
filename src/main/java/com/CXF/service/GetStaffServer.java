package com.CXF.service;

import com.commen.pojo.StaffDept;

public interface GetStaffServer {

    String getUserByStaff(String staff);

    String getStaffDept(StaffDept staffDept);

    //令牌验证服务
    String getToken();

}
