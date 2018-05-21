package com.CXF.model;

/**
 * @author ruiwu
 * @version V1.0
 * @Description:
 */
public class ExamData {
    private String examUID;
    private String examStatus;

    public String getExamUID() {
        return examUID;
    }

    public void setExamUID(String examUID) {
        this.examUID = examUID;
    }

    public String getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus;
    }

    public ExamData() {
        super();
    }

    public ExamData(String examUID, String examStatus) {
        this.examUID = examUID;
        this.examStatus = examStatus;
    }
}
