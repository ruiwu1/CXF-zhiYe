package com.CXF.service.impl;

import com.CXF.mapper.GetStaffMapper;
import com.CXF.service.GetStaffServer;
import com.commen.cst.Const;
import com.commen.pojo.*;
import com.commen.utils.CxfInvokeUtil;
import com.commen.utils.HttpRequestParser;
import com.commen.utils.JaxbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetStaffServerImpl implements GetStaffServer {

    @Autowired
    private GetStaffMapper getStaffMapper;

    @Value(value = "${Token_wsdlurl}")
    private String wsdlUrl;

    @Value(value = "${Token_format}")
    private String format;

    @Value(value = "${Token_callOperator}")
    private  String callOperator;

    @Value(value = "${Token_certificate}")
    private  String certificate;

    @Value(value = "${Token_address}")
    private  String address;

    //1、平台调用该服务获取员工有权限登录的系统信息。
   public String getUserByStaff(String staff){
       User user = new User();
       List<User> list = new ArrayList<User>();
       if (staff.indexOf("/") != -1){
           //参数为姓名/工作牌号
           String[] strings = staff.split("/");
               user.setUserName(strings[0]);
               user.setEmployeNo(strings[1]);
               staff = strings[1];
           list = getStaffMapper.getUserByStaff(user);
       }else {
                //直接使用平台的员工号
           user.setEmployeNo(staff);
           list = getStaffMapper.getUserByStaff(user);
            }
       //返回值为序列化后的xml数据
       String ResultFul = JaxbUtil.convertToXml(new StaffKey(staff,list),"UTF-8");
       //System.out.println(ResultFul);
       return ResultFul;
   }

    //2、获取员工有权限登录的科室信息
    public String getStaffDept(StaffDept staffDept) {
        List<Dept> list = getStaffMapper.getStaffDept(staffDept);
            for (Dept dept : list) {
                dept.setCode("171");
            }
            staffDept.setDepts(list);
            staffDept.setCustomSystemCode(Const.CUSTOMSYSTEMCODE);
        return JaxbUtil.convertToXml(staffDept,"UTF-8");
    }

    //令牌服务--传入url地址，识别
    public String getToken(){
       String serverName = "ValidToken";
       String Result = "";
       try {
           HttpServletRequest request  = HttpRequestParser.parse(address);
                String identity = request.getParameter("identity");
                String token = request.getParameter("token");
           if (identity == "ZYHIP"|| identity.equals("ZYHIP")){ //集成平台标识
                String msgHeader = JaxbUtil.convertToXml(new MsgHeader("ValidToken ",format,callOperator,certificate,null,null,null),"UTF-8");
                MsgBody msgBody = new MsgBody();
                    msgBody.setTokenCode(token);
                String mBody = JaxbUtil.convertToXml(msgBody,"UTF-8");
                Object[] obs = CxfInvokeUtil.invoke(wsdlUrl,msgHeader,mBody);
                //假设客户端调用
                if(obs != null && obs.length > 0){
                    Result = (String)obs[0];
                }
                    MsgBody body = JaxbUtil.converyToJavaBean(Result, MsgBody.class);
                    //序列化
            }else {
                //不是平台标识
                System.out.println("不是平台标识");
               Result="不是平台标识";
            }
           return Result;
       } catch (JAXBException e) {
           e.printStackTrace();
           return "出错啦";
       }
    }
}
