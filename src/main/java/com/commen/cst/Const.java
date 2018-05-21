package com.commen.cst;

import com.commen.utils.CombinationUtils;
import com.commen.utils.FtpPropertyUtils;
import com.commen.utils.SpringContextUtil;

public class Const {

    public static final String SESSION_IS_ADMIN = "SESSION_IS_ADMIN";

    public final static String APPLICATION_JSON_VALUE = "application/json";

    public final static String APPLICATION_JSON_UTF8_VALUE = APPLICATION_JSON_VALUE + ";charset=UTF-8";

    public final static String CALLREADADDRESS = "E:/IUPACS/address.txt";
    //业务系统代码
    public final static String CUSTOMSYSTEMCODE = "p0201";
    // 登录系统编码
    public final static String LOGINSYSTEMCODE = "P02";
    //  登录系统名称
    public final static String LOGINSYSTEMNAME = "pacs";
    //调用智业接口
    //短信相关
    public static CombinationUtils combinationUtils ;
    public static String WSDLURL ; //认证地址
    public static String FORMAT ;
    public static String CALLOPERATOR ;		//调用操作者
    public static String CERTIFICATE ;//放射凭证号
    public static String ULTRASOUND;//超声凭证
    public static String MSGNO ;//消息唯一标识
    static {
        combinationUtils = (CombinationUtils) SpringContextUtil.getBean("combinationUtils");
        WSDLURL=combinationUtils.getWsdlUrl();
        FORMAT=combinationUtils.getFormat();
        CALLOPERATOR=combinationUtils.getCallOperator();
        CERTIFICATE=combinationUtils.getCertificate();
        ULTRASOUND=combinationUtils.getUltrasound();
        MSGNO=combinationUtils.getMsgNo();
    }

    //ftp上传相关
    public static FtpPropertyUtils ftpPropertyUtils ;
    public static String FTPHOSTNAME; //ftp地址
    public static Integer FTPPORT; //ftp地址
    public static String FTPUSERNAME; //ftp地址
    public static String FTPPASSWORD ; //ftp地址

    public static String SZY_FTPHOSTNAME; //省中医图像存储ftp地址
    public static Integer SZY_FTPPORT; //省中医图像存储ftp地址
    public static String SZY_FTPUSERNAME; //省中医图像存储ftp地址
    public static String SZY_FTPPASSWORD ; //省中医图像存储ftp地址
    static {
        ftpPropertyUtils= (FtpPropertyUtils) SpringContextUtil.getBean("ftpPropertyUtils");
        FTPHOSTNAME=ftpPropertyUtils.getFtpHostname();
        FTPPORT=ftpPropertyUtils.getFtpPort();
        FTPUSERNAME= ftpPropertyUtils.getFrpUserName();
        FTPPASSWORD=ftpPropertyUtils.getFtpPassword();
        //省中医字段
        SZY_FTPHOSTNAME=ftpPropertyUtils.getSzy_ftpHostname();
        SZY_FTPPORT=ftpPropertyUtils.getFtpPort();
        SZY_FTPUSERNAME=ftpPropertyUtils.getSzy_frpUserName();
        SZY_FTPPASSWORD=ftpPropertyUtils.getSzy_ftpPassword();
    }
}
