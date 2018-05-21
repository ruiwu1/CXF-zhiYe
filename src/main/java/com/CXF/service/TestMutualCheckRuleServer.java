package com.CXF.service;

import com.commen.pojo.zhiye.ExamApplyInfo;
import com.commen.pojo.zhiye.PacsReport;
import com.commen.pojo.zhiye.ReturnContent;

import java.util.List;

/**
 * 检查系统接入医院信息集成平台的院内接口
 */

public interface TestMutualCheckRuleServer {

    void testUpdateRadiationApplyStatus(String examUID,String examStatus);

    void sendPacsReport(String examUID);
}
