package com.commen.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ruiwu
 * @version V1.0
 * @Description:
 */
@Component("ftpPropertyUtils")
public class FtpPropertyUtils {

    private String ftpHostname;
    private Integer ftpPort;
    private String frpUserName;
    private String ftpPassword;

    private String szy_ftpHostname;
    private String szy_ftpPort;
    private String szy_frpUserName;
    private String szy_ftpPassword;

    public String getFtpHostname() {
        return ftpHostname;
    }
    @Value(value = "#{configProperties.ftp_hostname}")
    public void setFtpHostname(String ftpHostname) {
        this.ftpHostname = ftpHostname;
    }

    public Integer getFtpPort() {
        return ftpPort;
    }
    @Value(value = "#{configProperties.ftp_port}")
    public void setFtpPort(Integer ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFrpUserName() {
        return frpUserName;
    }
    @Value(value = "#{configProperties.ftp_username}")
    public void setFrpUserName(String frpUserName) {
        this.frpUserName = frpUserName;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }
    @Value(value = "#{configProperties.ftp_password}")
    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public String getSzy_ftpHostname() {
        return szy_ftpHostname;
    }
    @Value(value = "#{configProperties.ftp_image_hostname}")
    public void setSzy_ftpHostname(String szy_ftpHostname) {
        this.szy_ftpHostname = szy_ftpHostname;
    }

    public String getSzy_ftpPort() {
        return szy_ftpPort;
    }
    @Value(value = "#{configProperties.ftp_image_port}")
    public void setSzy_ftpPort(String szy_ftpPort) {
        this.szy_ftpPort = szy_ftpPort;
    }

    public String getSzy_frpUserName() {
        return szy_frpUserName;
    }
    @Value(value = "#{configProperties.ftp_image_username}")
    public void setSzy_frpUserName(String szy_frpUserName) {
        this.szy_frpUserName = szy_frpUserName;
    }

    public String getSzy_ftpPassword() {
        return szy_ftpPassword;
    }
    @Value(value = "#{configProperties.ftp_image_password}")
    public void setSzy_ftpPassword(String szy_ftpPassword) {
        this.szy_ftpPassword = szy_ftpPassword;
    }
}
