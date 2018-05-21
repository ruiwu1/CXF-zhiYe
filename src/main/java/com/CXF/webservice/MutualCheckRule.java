package com.CXF.webservice;

import javax.jws.WebService;

/**
 * @author ruiwu
 * @version V1.0
 * @Description:
 */
@WebService
public interface MutualCheckRule {
    //1、获取超声检查申请单信息
    public String GetUltrasoundExamApplyInfo(String xmlparam);

    //2、更新超声检查申请单信息
    public String UpdateUltrasoundExamApplyStatus(String xmlparam);

    //3、发送超声检查报告
    public String SendUltrasoundReport(String xmlparam);

    //4、获取放射检查申请单信息
    public String GetRadiationApplyInfo(String xmlparam);

    //5、更新放射检查申请单信息
    public String UpdateRadiationApplyStatus(String xmlparam);

    //6、发送放射检查报告
    public String SendRadiationReport(String xmlparam);
}
