package com.CXF.controller;

import com.CXF.service.MutualCheckRuleServer;
import com.CXF.service.TestMutualCheckRuleServer;
import com.CXF.service.impl.MutualCheckRuleServerImpl;
import com.commen.controller.BaseController;
import com.commen.cst.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author ruiwu
 * @version V1.0
 * @Description:
 */
@Controller
@RequestMapping("/auth/mutualCheckRule")
public class MutualCheckRuleController extends BaseController{
    @Autowired
    private TestMutualCheckRuleServer mutualCheckRuleServer;

    @RequestMapping(value = "/testUpdateRadiationApplyStatus", method= RequestMethod.POST,produces = Const.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    //测试--更新放射检查申请单信息
    private String  testUpdateRadiationApplyStatus(final String examUID,final String examStatus){
        System.out.println(examUID+"测试获取数据"+examStatus);
        if(examStatus.equals("7")){//报告完成
            Runnable myRunnable = new Runnable(){
                public void run(){
                    logger.info("开启线程执行发送检查报告流程");
                    mutualCheckRuleServer.sendPacsReport(examUID);
                }
            };
            Thread thread = new Thread(myRunnable);
            thread.start();
        }
        Runnable myRunnable = new Runnable(){
            public void run(){
                logger.info("开启线程执行更新检查状态流程");
                mutualCheckRuleServer.testUpdateRadiationApplyStatus(examUID,examStatus);
            }
        };
        Thread thread = new Thread(myRunnable);
        thread.start();
        return "success:close";
    }




}
