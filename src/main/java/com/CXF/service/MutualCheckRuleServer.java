package com.CXF.service;

import com.commen.pojo.zhiye.ApplyStatus;
import com.commen.pojo.zhiye.ExamApplyInfo;
import com.commen.pojo.zhiye.PacsReport;
import com.commen.pojo.zhiye.ReturnContent;

import java.util.List;

/**
 * 检查系统接入医院信息集成平台的院内接口
 */

public interface MutualCheckRuleServer {

    //1、获取检查申请单信息
    public String GetExamApplyInfo(ExamApplyInfo examApplyInfo);

    //2、更新检查申请单信息
    public String UpdateExamApplyStatus(List<ReturnContent> list);

    //3、发送检查报告
    public String SendPacsReport(PacsReport pacsReport);

    void testUpdateRadiationApplyStatus();
}
