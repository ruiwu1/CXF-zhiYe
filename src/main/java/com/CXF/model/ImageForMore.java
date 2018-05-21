package com.CXF.model;

/**
 * @author ruiwu
 * @version V1.0
 * @Description:  图像和报告的公共类
 */
public class ImageForMore {


    private String InstanceUID;
    private String SeriesUID;
    private String ImageSubNo;
    private String ExamUID;
    private String FilePath;  //存储路径
    private String FileName;  //存储文件名
    private String StudyUID;  //StudyUID
    private String ImageServerIP;
    private String InternalType;  //类别  PrintRept为报告
    private String ImageMainNo;

    public String getImageMainNo() {
        return ImageMainNo;
    }

    public void setImageMainNo(String imageMainNo) {
        ImageMainNo = imageMainNo;
    }

    public String getImageSubNo() {
        return ImageSubNo;
    }

    public void setImageSubNo(String imageSubNo) {
        ImageSubNo = imageSubNo;
    }

    public String getInstanceUID() {
        return InstanceUID;
    }

    public void setInstanceUID(String instanceUID) {
        InstanceUID = instanceUID;
    }

    public String getSeriesUID() {
        return SeriesUID;
    }

    public void setSeriesUID(String seriesUID) {
        SeriesUID = seriesUID;
    }

    public String getExamUID() {
        return ExamUID;
    }

    public void setExamUID(String examUID) {
        ExamUID = examUID;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getStudyUID() {
        return StudyUID;
    }

    public void setStudyUID(String studyUID) {
        StudyUID = studyUID;
    }

    public String getImageServerIP() {
        return ImageServerIP;
    }

    public void setImageServerIP(String imageServerIP) {
        ImageServerIP = imageServerIP;
    }

    public String getInternalType() {
        return InternalType;
    }

    public void setInternalType(String internalType) {
        InternalType = internalType;
    }
}
