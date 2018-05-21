package com.CXF.webservice.test;

import com.CXF.service.MutualCheckRuleServer;
import com.CXF.service.impl.GetStaffServerImpl;
import com.CXF.service.impl.MutualCheckRuleServerImpl;
import com.commen.pojo.MsgBody;
import com.commen.pojo.StaffDept;
import com.commen.pojo.zhiye.ApplyStatus;
import com.commen.pojo.zhiye.ExamApplyInfo;
import com.commen.utils.CxfInvokeUtil;
import com.commen.utils.FileHelper;
import com.commen.utils.JaxbUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

public class TestClient {

    @Autowired
    private MutualCheckRuleServer mutualCheckRuleServer;

    public static void main(String[] args) {
        //mutualCheckRuleServer.GetExamApplyInfo(new ExamApplyInfo());
        //new MutualCheckRuleServerImpl().GetExamApplyInfo(new ExamApplyInfo());
        //2、更新检查申请单信息
        //new MutualCheckRuleServerImpl().UpdateExamApplyStatus();
        //String staffDept = new GetStaffServerImpl().getStaffDept(new StaffDept());
        //System.out.println(staffDept);
    }
}
